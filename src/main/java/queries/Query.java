package queries;

import java.util.Objects;

public class Query {

    private final String filter;
    private final Operator operator;
    private final Object[] arguments;

    private Query(String filter, Operator operator, Object... arguments) {
        this.filter = Objects.requireNonNull(filter);
        this.operator = Objects.requireNonNull(operator);
        this.arguments = Objects.requireNonNull(arguments);
    }

    public static Query query(String filter, Operator operator, Object... arguments) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Query query = (Query) o;
        return Objects.equals(filter, query.filter) &&
                Objects.equals(operator, query.operator) &&
                Objects.equals(arguments, query.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filter, operator, arguments);
    }

    @Override
    public String toString() {
        return operator.format(filter, arguments);
    }
}
