package evaluators;

import com.google.common.io.CharStreams;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import static evaluators.JsonPathExpression.filter;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonPathTest {

    private JsonPathEvaluator evaluator;

    @Before
    public void initialize() {
        evaluator = new JsonPathEvaluator(loadJson("vcap_services.json"));
    }

    @Test
    public void readExistingScalarTest() {
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
        // when
        Optional<Integer> port = evaluator.scalar(
                filter("cloudamqp"),
                filter("name", "cloudamqp-9dbc6"),
                filter("Nonexistent")
        );

        // then
        assertThat(port.isPresent(), is(false));
    }

    @Test
    public void existentUserProvidedScalarTest() {
        // when
        Optional<String> username = evaluator.scalar(
                filter("name", "sub"),
                filter("username")
        );

        // then
        assertThat(username.get(), is("usersub"));
    }

    private String loadJson(String name) {
        try {
            return CharStreams.toString(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(name)));
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid file name: " + name);
        }
    }
}
