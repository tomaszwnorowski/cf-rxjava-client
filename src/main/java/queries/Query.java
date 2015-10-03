package queries;

import java.util.Objects;

public class Query {

    private final String filter;
    private final Operator operator;
    private final Object[] arguments;

    public Query(String filter, Operator operator, Object... arguments) {
        this.filter = Objects.requireNonNull(filter);
        this.operator = Objects.requireNonNull(operator);
        this.arguments = Objects.requireNonNull(arguments);
    }

    public static Query from(String filter, Operator operator, Object... arguments) {
        return new Query(filter, operator, arguments);
    }

    public String getFilter() {
        return filter;
    }

    public Operator getOperator() {
        return operator;
    }

    public Object[] getArguments() {
        return arguments;
    }
}
