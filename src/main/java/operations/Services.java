package operations;

import feign.*;
import models.service.Service;
import models.service.ServicePlan;
import queries.Query;
import queries.V2QueryExpander;
import rx.Observable;

import java.net.URI;
import java.util.UUID;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface Services {

    @RequestLine("GET")
    Observable<Service> getServices(URI uri);

    @RequestLine("DELETE /v2/services/{service}")
    Observable<Response> deleteService(
            @Param("service") UUID service
    );

    @RequestLine("GET /v2/services/{service}/service_plans")
    Observable<ServicePlan> getServicePlans(
            @Param("service") UUID service
    );

    @RequestLine("GET /v2/services/{service}/service_plans?q={q}")
    Observable<ServicePlan> getServicePlans(
            @Param("service") UUID service,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/services")
    Observable<Service> getServices();

    @RequestLine("GET /v2/services/{service}")
    Observable<Service> getServices(
            @Param("service") UUID service
    );

    @RequestLine("GET /v2/services?q={q}")
    Observable<Service> getServices(
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

}
