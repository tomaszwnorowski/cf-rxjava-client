package operations;

import feign.Headers;
import feign.RequestLine;
import models.ServiceInstance;
import rx.Observable;

import java.net.URI;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface ServiceInstances {

    @RequestLine("GET")
    Observable<ServiceInstance> getServiceInstances(URI uri);

}
