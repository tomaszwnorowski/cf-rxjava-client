package queries;

public class Query {

    private final String filter;
    private final Operator operator;
    private final Object[] arguments;

    public Query(String filter, Operator operator, Object... arguments) {
        this.filter = filter;
        this.operator = operator;
        this.arguments = arguments;
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
