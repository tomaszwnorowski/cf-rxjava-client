package client;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.function.Supplier;

public class OAuth2RequestInterceptor implements RequestInterceptor {
    private final Supplier<String> supplier;

    public OAuth2RequestInterceptor(String token) {
        this(() -> token);
    }

    public OAuth2RequestInterceptor(Supplier<String> supplier) {
        this.supplier = supplier;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + supplier.get());
    }
}
