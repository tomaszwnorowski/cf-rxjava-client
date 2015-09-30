package queries;

import feign.Param;

import java.util.Objects;

public class QueryExpander implements Param.Expander {
    @Override
    public String expand(Object value) {
        Objects.requireNonNull(value, "Expected: " + Query.class + ", but was: null");

        if (!Query.class.equals(value.getClass())) {
            throw new IllegalArgumentException("Expected: " + Query.class + ", but was: " + value.getClass());
        }

        final Query query = (Query) value;
        return query.getOperator().format(query.getFilter(), query.getArguments());
    }
}
