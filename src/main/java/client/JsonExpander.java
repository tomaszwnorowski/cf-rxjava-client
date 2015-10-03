package client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Param;

import java.util.Objects;

public class JsonExpander implements Param.Expander {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public String expand(Object value) {
        Objects.requireNonNull(value);

        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
