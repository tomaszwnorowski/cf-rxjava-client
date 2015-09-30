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

    @RequestLine("/v2/services")
    Observable<Service> getServices();

    @RequestLine("/v2/services/{guid}")
    Observable<Service> getServices(@Param("guid") UUID guid);
}
