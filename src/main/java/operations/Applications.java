package operations;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;
import models.Route;
import models.application.Application;
import models.application.ApplicationSummary;
import models.application.ApplicationUpdate;
import models.service.ServiceBinding;
import queries.Query;
import queries.V2QueryExpander;
import rx.Observable;

import java.net.URI;
import java.util.UUID;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface Applications {

    @RequestLine("GET")
    Observable<Application> getApplications(URI uri);

    @RequestLine("PUT /v2/apps/{app}/routes/{route}")
    Observable<Application> addApplicationRoute(
            @Param("app") UUID app,
            @Param("route") UUID route
    );

    @RequestLine("DELETE /v2/apps/{app}")
    Observable<Response> deleteApplication(
            @Param("app") UUID app
    );

    @RequestLine("GET /v2/apps/{app}/summary")
    Observable<ApplicationSummary> getApplicationSummary(
            @Param("app") UUID app
    );

    @RequestLine("GET /v2/apps")
    Observable<Application> getApplications();

    @RequestLine("GET /v2/apps/{app}")
    Observable<Application> getApplications(
            @Param("app") UUID app
    );

    @RequestLine("GET /v2/apps?q={q}")
    Observable<Application> getApplications(
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/apps/{app}/route")
    Observable<Route> getApplicationRoutes(
            @Param("app") UUID app
    );

    @RequestLine("GET /v2/apps/{app}/service_binding")
    Observable<ServiceBinding> getApplicationServiceBindings(
            @Param("app") UUID app
    );

    @RequestLine("DELETE /v2/apps/{app}/routes/{route}")
    Observable<Application> removeApplicationRoute(
            @Param("app") UUID app,
            @Param("route") UUID route
    );

    @RequestLine("DELETE /v2/apps/{app}/service_binding/{service_binding}")
    Observable<Application> removeApplicationServiceBinding(
            @Param("app") UUID app,
            @Param("service_binding") UUID serviceBinding
    );

    @RequestLine("POST /v2/apps/{app}/restage")
    Observable<Application> restageApplication(
            @Param("app") UUID app
    );

    @RequestLine("PUT /v2/apps/{app}")
    Observable<Application> updateApplication(
            @Param("app") UUID app,
            ApplicationUpdate update
    );

}
