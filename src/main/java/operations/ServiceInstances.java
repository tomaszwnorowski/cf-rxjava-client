package operations;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import models.Route;
import models.service.ServiceBinding;
import models.service.ServiceInstance;
import models.service.ServiceInstanceCreate;
import models.service.ServiceInstanceUpdate;
import queries.Query;
import queries.V2QueryExpander;
import rx.Observable;

import java.net.URI;
import java.util.UUID;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface ServiceInstances {

    @RequestLine("GET")
    Observable<ServiceInstance> getServiceInstances(URI uri);

    @RequestLine("POST /v2/service_instances")
    Observable<ServiceInstance> createServiceInstance(
            ServiceInstanceCreate create
    );

    @RequestLine("DELETE /v2/service_instances/{service_instance}")
    Observable<ServiceInstance> deleteServiceInstance(
            @Param("service_instance") UUID serviceInstance
    );

    @RequestLine("GET /v2/service_instances/{service_instance}/routes")
    Observable<Route> getServiceInstanceRoutes(
            @Param("service_instance") UUID serviceInstance
    );

    @RequestLine("GET /v2/service_instances/{service_instance}/service_bindings")
    Observable<ServiceBinding> getServiceInstanceBindings(
            @Param("service_instance") UUID serviceInstance
    );

    @RequestLine("GET /v2/service_instances")
    Observable<ServiceInstance> getServiceInstances();

    @RequestLine("GET /v2/service_instances/{service_instance}")
    Observable<ServiceInstance> getServiceInstances(
            @Param("service_instance") UUID serviceInstance
    );

    @RequestLine("GET /v2/service_instances?q={q}")
    Observable<ServiceInstance> getServiceInstances(
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("PUT /v2/service_instances/{service_instance}")
    Observable<ServiceInstance> updateServiceInstance(
            @Param("service_instance") UUID serviceInstance,
            ServiceInstanceUpdate update
    );

}
