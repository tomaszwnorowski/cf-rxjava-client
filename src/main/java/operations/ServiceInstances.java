package operations;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import models.Route;
import models.ServiceBinding;
import models.ServiceInstance;
import client.JsonExpander;
import queries.Query;
import queries.QueryExpander;
import rx.Observable;

import java.net.URI;
import java.util.UUID;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface ServiceInstances {

    @RequestLine("GET")
    Observable<ServiceInstance> getServiceInstances(URI uri);

    @RequestLine("GET /v2/service_instances")
    Observable<ServiceInstance> getServiceInstances();

    @RequestLine("GET /v2/service_instances?q={q}")
    Observable<ServiceInstance> getServiceInstances(
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("POST /v2/service_instances")
    @Body("%7B\"name\":\"{name}\",\"service_plan_guid\":\"{service_plan_guid}\",\"space_guid\":\"{space_guid}\"%7D")
    Observable<ServiceInstance> createServiceInstance(
            @Param("name") String name,
            @Param("service_plan_guid") UUID servicePlan,
            @Param("space_guid") UUID space
    );

    @RequestLine("POST /v2/service_instances")
    @Body("%7B\"name\":\"{name}\",\"service_plan_guid\":\"{service_plan_guid}\",\"space_guid\":\"{space_guid}\",\"parameters\":{parameters}%7D")
    Observable<ServiceInstance> createServiceInstance(
            @Param("name") String name,
            @Param("service_plan_guid") UUID servicePlan,
            @Param("space_guid") UUID space,
            @Param(value = "parameters", expander = JsonExpander.class) Object parameters
    );

    @RequestLine("PUT /v2/service_instances/{service_instance}")
    @Body("%7B\"name\":\"{name}\",\"service_plan_guid\":\"{service_plan_guid}\"%7D")
    Observable<ServiceInstance> updateServiceInstance(
            @Param("service_instance") UUID serviceInstance,
            @Param("name") String name,
            @Param("service_plan_guid") UUID servicePlan
    );

    @RequestLine("PUT /v2/service_instances/{service_instance}")
    @Body("%7B\"name\":\"{name}\",\"service_plan_guid\":\"{service_plan_guid}\",\"parameters\":{parameters}%7D")
    Observable<ServiceInstance> updateServiceInstance(
            @Param("service_instance") UUID serviceInstance,
            @Param("name") String name,
            @Param("service_plan_guid") UUID servicePlan,
            @Param(value = "parameters", expander = JsonExpander.class) Object parameters
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
}
