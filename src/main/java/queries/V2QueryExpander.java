package queries;

import feign.Param;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class V2QueryExpander implements Param.Expander {

    @Override
    public String expand(Object value) {
        Objects.requireNonNull(value);

        if (!Query.class.equals(value.getClass())) {
            throw new IllegalArgumentException("Expected instance of " + Query.class + ", but was: " + value.getClass());
        }

        final Query query = (Query) value;
        if (query.getOperator() == Operator.EQ) {
            return String.format("%s:%s", query.getFilter(), query.getArguments()[0].toString());
        } else if (query.getOperator() == Operator.IN) {
            return String.format("%s IN %s", query.getFilter(), Arrays.asList(query.getArguments()).stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(",")));
        } else {
            throw new IllegalArgumentException("Invalid operator: " + query.getOperator());
        }
    }
}
