package operations;

import feign.*;
import models.*;
import queries.Query;
import queries.QueryExpander;
import rx.Observable;

import java.net.URI;
import java.util.UUID;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface Spaces {

    @RequestLine("GET")
    Observable<Space> getSpaces(URI uri);

    @RequestLine("POST /v2/spaces")
    @Body("%7B\"name\":\"{name}\", \"organization_guid\":\"{organization_guid}\"%7D")
    Observable<Space> createSpace(
            @Param("name") String name,
            @Param("organization_guid") UUID organization
    );

    @RequestLine("PUT /v2/spaces/{space}")
    @Body("%7B\"name\":\"{name}\"%7D")
    Observable<Space> updateSpace(
            @Param("space") UUID space,
            @Param("name") String name
    );

    @RequestLine("DELETE /v2/spaces/{space}")
    Observable<Response> deleteSpace(
            @Param("space") UUID space
    );

    @RequestLine("PUT /v2/spaces/{space}/auditors/{user}")
    Observable<Space> addSpaceAuditor(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("DELETE /v2/spaces/{space}/auditors/{user}")
    Observable<Space> removeSpaceAuditor(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("GET /v2/spaces/{space}/auditors")
    Observable<User> getSpaceAuditors(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/auditors?q={q}")
    Observable<User> getSpaceAuditors(
            @Param("space") UUID space,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("PUT /v2/spaces/{space}/developers/{user}")
    Observable<Space> addSpaceDeveloper(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("DELETE /v2/spaces/{space}/developers/{user}")
    Observable<Space> removeSpaceDeveloper(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("GET /v2/spaces/{space}/developers")
    Observable<User> getSpaceDevelopers(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/developers?q={q}")
    Observable<User> getSpaceDevelopers(
            @Param("space") UUID space,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("PUT /v2/spaces/{space}/managers/{user}")
    Observable<Space> addSpaceManager(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("DELETE /v2/spaces/{space}/managers/{user}")
    Observable<Space> removeSpaceManager(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("GET /v2/spaces/{space}/managers")
    Observable<User> getSpaceManagers(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/managers?q={q}")
    Observable<User> getSpaceManagers(
            @Param("space") UUID space,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}/routes")
    Observable<Route> getSpaceRoutes(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/routes?q={q}")
    Observable<Route> getSpaceRoutes(
            @Param("space") UUID space,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("PUT /v2/spaces/{space}/security_groups/{security_group}")
    Observable<Space> addSpaceSecurityGroup(
            @Param("space") UUID space,
            @Param("security_group") UUID securityGroup
    );

    @RequestLine("DELETE /v2/spaces/{space}/security_groups/{security_group}")
    Observable<Space> removeSpaceSecurityGroup(
            @Param("space") UUID space,
            @Param("security_group") UUID securityGroup
    );

    @RequestLine("GET /v2/spaces/{space}/security_groups")
    Observable<SecurityGroup> getSpaceSecurityGroups(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/security_groups?q={q}")
    Observable<SecurityGroup> getSpaceSecurityGroups(
            @Param("space") UUID space,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}/apps")
    Observable<Application> getSpaceApplications(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/apps?q={q}")
    Observable<Application> getSpaceApplications(
            @Param("space") UUID space,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}/services")
    Observable<Service> getSpaceServices(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/services?q={q}")
    Observable<Service> getSpaceServices(
            @Param("space") UUID space,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}/service_instances")
    Observable<Service> getSpaceServiceInstances(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/service_instances?q={q}")
    Observable<Service> getSpaceServiceInstances(
            @Param("space") UUID space,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces")
    Observable<Space> getSpaces();

    @RequestLine("GET /v2/spaces?q={q}")
    Observable<Space> getSpaces(
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}")
    Observable<Space> getSpaces(@Param("space") UUID space);
}
