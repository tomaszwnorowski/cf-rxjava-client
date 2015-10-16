package evaluators;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class JsonPathEvaluator {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonPathEvaluator.class);
    private final DocumentContext documentContext;

    public JsonPathEvaluator(Object json) {
        this.documentContext = JsonPath.parse(json);
    }

    public JsonPathEvaluator(String json) {
        this.documentContext = JsonPath.parse(json);
    }

    public <T> Optional<T> scalar(JsonPathExpression expression) {
        return scalar(Collections.singleton(expression));
    }

    public <T> Optional<T> scalar(JsonPathExpression... expressions) {
        return scalar(Arrays.asList(expressions));
    }

    public <T> Optional<T> scalar(Collection<JsonPathExpression> expressions) {
        final List<T> matches = evaluate(expressions);
        return matches.isEmpty() ? Optional.empty() : Optional.ofNullable(matches.get(0));
    }

    public <T> List<T> list(JsonPathExpression expression) {
        return list(Collections.singleton(expression));
    }

    public <T> List<T> list(JsonPathExpression... expressions) {
        return list(Arrays.asList(expressions));
    }

    public <T> List<T> list(Collection<JsonPathExpression> expressions) {
        final List<List<T>> matches = evaluate(expressions);
        return matches.isEmpty() ? Collections.emptyList() : matches.get(0);
    }

    private <T> List<T> evaluate(Collection<JsonPathExpression> expressions) {
        final String path = "$.." + expressions.stream()
                .map(JsonPathExpression::format)
                .collect(Collectors.joining(".."));

        LOGGER.debug("evaluate: {}", path);
        return documentContext.read(path);
    }
}
