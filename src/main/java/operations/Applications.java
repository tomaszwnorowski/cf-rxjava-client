package operations;

import feign.Headers;
import feign.RequestLine;
import models.Application;
import rx.Observable;

import java.net.URI;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface Applications {

    @RequestLine("GET")
    Observable<Application> getApplications(URI uri);

}
