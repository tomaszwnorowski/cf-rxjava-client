package operations;

import feign.*;
import models.*;
import models.application.Application;
import models.service.Service;
import models.service.ServiceInstance;
import models.space.Space;
import models.space.SpaceCreate;
import models.space.SpaceUpdate;
import models.space.SpaceUser;
import models.summary.SpaceSummary;
import models.user.User;
import queries.Query;
import queries.V2QueryExpander;
import rx.Observable;

import java.net.URI;
import java.util.UUID;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface Spaces {

    @RequestLine("GET")
    Observable<Space> getSpaces(URI uri);

    @RequestLine("PUT /v2/spaces/{space}/auditors/{user}")
    Observable<Space> addSpaceAuditor(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("PUT /v2/spaces/{space}/auditors")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Space> addSpaceAuditor(
            @Param("space") UUID space,
            @Param("username") String username
    );

    @RequestLine("PUT /v2/spaces/{space}/developers/{user}")
    Observable<Space> addSpaceDeveloper(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("PUT /v2/spaces/{space}/developers")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Space> addSpaceDeveloper(
            @Param("space") UUID space,
            @Param("username") String username
    );

    @RequestLine("PUT /v2/spaces/{space}/managers/{user}")
    Observable<Space> addSpaceManager(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("PUT /v2/spaces/{space}/managers")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Space> addSpaceManager(
            @Param("space") UUID space,
            @Param("username") String username
    );

    @RequestLine("PUT /v2/spaces/{space}/security_groups/{security_group}")
    Observable<Space> addSpaceSecurityGroup(
            @Param("space") UUID space,
            @Param("security_group") UUID securityGroup
    );

    @RequestLine("POST /v2/spaces")
    Observable<Space> createSpace(
            SpaceCreate create
    );

    @RequestLine("DELETE /v2/spaces/{space}?recursive={recursive}&async={async}")
    Observable<Response> deleteSpace(
            @Param("space") UUID space,
            @Param("recursive") boolean recursive,
            @Param("async") boolean async
    );

    @RequestLine("DELETE /v2/spaces/{space}/auditors/{user}")
    Observable<Space> removeSpaceAuditor(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("DELETE /v2/spaces/{space}/auditors")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Space> removeSpaceAuditor(
            @Param("space") UUID space,
            @Param("username") String username
    );

    @RequestLine("DELETE /v2/spaces/{space}/developers/{user}")
    Observable<Space> removeSpaceDeveloper(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("DELETE /v2/spaces/{space}/developers")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Space> removeSpaceDeveloper(
            @Param("space") UUID space,
            @Param("username") String username
    );

    @RequestLine("DELETE /v2/spaces/{space}/managers/{user}")
    Observable<Space> removeSpaceManager(
            @Param("space") UUID space,
            @Param("user") UUID user
    );

    @RequestLine("DELETE /v2/spaces/{space}/managers")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Space> removeSpaceManager(
            @Param("space") UUID space,
            @Param("username") String username
    );

    @RequestLine("GET /v2/spaces/{space}/summary")
    Observable<SpaceSummary> getSpaceSummary(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/apps")
    Observable<Application> getSpaceApplications(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/apps?q={q}")
    Observable<Application> getSpaceApplications(
            @Param("space") UUID space,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}/auditors")
    Observable<User> getSpaceAuditors(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/auditors?q={q}")
    Observable<User> getSpaceAuditors(
            @Param("space") UUID space,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}/developers")
    Observable<User> getSpaceDevelopers(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/developers?q={q}")
    Observable<User> getSpaceDevelopers(
            @Param("space") UUID space,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}/managers")
    Observable<User> getSpaceManagers(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/managers?q={q}")
    Observable<User> getSpaceManagers(
            @Param("space") UUID space,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}/routes")
    Observable<Route> getSpaceRoutes(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/routes?q={q}")
    Observable<Route> getSpaceRoutes(
            @Param("space") UUID space,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}/security_groups")
    Observable<SecurityGroup> getSpaceSecurityGroups(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/security_groups?q={q}")
    Observable<SecurityGroup> getSpaceSecurityGroups(
            @Param("space") UUID space,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}/service_instances")
    Observable<ServiceInstance> getSpaceServiceInstances(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/service_instances?q={q}")
    Observable<ServiceInstance> getSpaceServiceInstances(
            @Param("space") UUID space,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces/{space}/services")
    Observable<Service> getSpaceServices(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces/{space}/services?q={q}")
    Observable<Service> getSpaceServices(
            @Param("space") UUID space,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/spaces")
    Observable<Space> getSpaces();

    @RequestLine("GET /v2/spaces/{space}")
    Observable<Space> getSpaces(
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/spaces?q={q}")
    Observable<Space> getSpaces(
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("DELETE /v2/spaces/{space}/security_groups/{security_group}")
    Observable<Space> removeSpaceSecurityGroup(
            @Param("space") UUID space,
            @Param("security_group") UUID securityGroup
    );

    @RequestLine("GET /v2/spaces/{space}/user_roles")
    Observable<SpaceUser> getSpaceUserRoles(
            @Param("space") UUID space
    );

    @RequestLine("PUT /v2/spaces/{space}")
    Observable<Space> updateSpace(
            @Param("space") UUID space,
            SpaceUpdate update
    );
}
