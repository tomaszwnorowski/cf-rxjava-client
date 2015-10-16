package client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import models.Page;
import rx.Observable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.function.Function;

public class CfRxDecoder<T> implements Decoder {
    private static final int BUFFER_SIZE = 32;
    private final ObjectMapper mapper;
    private final Function<URI, Observable<T>> fetcher;

    public CfRxDecoder(ObjectMapper mapper, Function<URI, Observable<T>> fetcher) {
        this.mapper = mapper;
        this.fetcher = fetcher;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        if (response.body() == null) {
            return null;
        }
        Reader reader = response.body().asReader();
        if (!reader.markSupported()) {
            reader = new BufferedReader(reader, BUFFER_SIZE);
        }
        try {
            final char[] buffer = new char[BUFFER_SIZE];

            reader.mark(BUFFER_SIZE);
            if (reader.read(buffer) == -1) {
                return Observable.just(response);
            }

            reader.reset();
            final ParameterizedType parameterizedType = (ParameterizedType) type;
            if (new String(buffer).contains("total_results")) {
                return concatPages(mapper.readValue(reader, mapper.constructType(toPageType(parameterizedType))));
            } else {
                return Observable.just(mapper.readValue(reader, mapper.constructType(toScalarType(parameterizedType))));
            }
        } catch (RuntimeJsonMappingException e) {
            if (e.getCause() != null && e.getCause() instanceof IOException) {
                throw IOException.class.cast(e.getCause());
            }
            throw e;
        }
    }

    private Observable<T> concatPages(Page<T> page) {
        final Observable<T> resources = Observable.from(page.getResources());

        if (page.getNextUrl() != null) {
            return resources.concatWith(Observable.defer(() -> fetcher.apply(page.getNextUrl())));
        } else {
            return resources;
        }
    }

    private Type toPageType(ParameterizedType type) {
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return type.getActualTypeArguments();
            }

            @Override
            public Type getRawType() {
                return Page.class;
            }

            @Override
            public Type getOwnerType() {
                return type.getOwnerType();
            }
        };
    }

    private Type toScalarType(ParameterizedType type) {
        return type.getActualTypeArguments()[0];
    }
}
