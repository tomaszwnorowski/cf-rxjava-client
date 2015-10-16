package evaluators;

@FunctionalInterface
public interface JsonPathExpression {

    String format();

    static JsonPathExpression filter(String key) {
        return () -> key;
    }

    static JsonPathExpression filter(String key, String value) {
        return () -> String.format("[?(@.%s == %s)]", key, value);
    }
}
