package queries;

import feign.Param;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class V3QueryExpander implements Param.Expander {

    @Override
    public String expand(Object value) {
        Objects.requireNonNull(value);

        if (!Query.class.equals(value.getClass())) {
            throw new IllegalArgumentException("Expected instance of " + Query.class + ", but was: " + value.getClass());
        }

        final Query query = (Query) value;
        return String.format("%s=%s", query.getFilter(), Arrays.asList(query.getArguments()).stream()
                .map(Object::toString)
                .collect(Collectors.joining(",")));
    }
}
