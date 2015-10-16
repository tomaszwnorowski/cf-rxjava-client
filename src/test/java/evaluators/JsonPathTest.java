package evaluators;

import com.google.common.io.CharStreams;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import static evaluators.JsonPathExpression.filter;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonPathTest {

    @Test
    public void readExistingScalarTest() {
        // given
        JsonPathEvaluator evaluator = new JsonPathEvaluator(loadJson("vcap_services.json"));

        // when
        Optional<Integer> port = evaluator.scalar(
                filter("cloudamqp"),
                filter("name", "cloudamqp-9dbc6"),
                filter("port")
        );

        // then
        assertThat(port.get(), is(1234));
    }

    @Test
    public void readNonExistentScalarTest() {
        // given
        JsonPathEvaluator evaluator = new JsonPathEvaluator(loadJson("vcap_services.json"));

        // when
        Optional<Integer> port = evaluator.scalar(
                filter("cloudamqp"),
                filter("name", "cloudamqp-9dbc6"),
                filter("Nonexistent")
        );

        // then
        assertThat(port.isPresent(), is(false));
    }

    private String loadJson(String name) {
        try {
            return CharStreams.toString(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(name)));
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid file name: " + name);
        }
    }
}
