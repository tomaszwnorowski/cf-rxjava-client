package operations;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import models.Service;
import rx.Observable;

import java.net.URI;
import java.util.UUID;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface Services {

    @RequestLine("GET")
    Observable<Service> getServices(URI uri);

    @RequestLine("GET /v2/services")
    Observable<Service> getServices();

    @RequestLine("GET /v2/services/{service}")
    Observable<Service> getServices(@Param("service") UUID service);
}
