package operations;

import feign.*;
import models.Space;
import models.User;
import queries.Query;
import queries.QueryExpander;
import rx.Observable;

import java.net.URI;
import java.util.UUID;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface Spaces {

    @RequestLine("PUT /v2/spaces/{guid}/auditors/{auditor_guid}")
    Observable<Space> addSpaceAuditor(
            @Param("guid") UUID guid,
            @Param("auditor_guid") UUID auditorGuid
    );

    @RequestLine("DELETE /v2/spaces/{guid}/auditors/{auditor_guid}")
    Observable<Space> removeSpaceAuditor(
            @Param("guid") UUID guid,
            @Param("auditor_guid") UUID auditorGuid
    );

    @RequestLine("GET /v2/spaces/{guid}/auditors")
    Observable<User> getSpaceAuditors(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/spaces/{guid}/auditors?q={q}")
    Observable<User> getSpaceAuditors(
            @Param("guid") UUID guid,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("PUT /v2/spaces/{guid}/developers/{developer_guid}")
    Observable<Space> addSpaceDeveloper(
            @Param("guid") UUID guid,
            @Param("developer_guid") UUID developerGuid
    );

    @RequestLine("DELETE /v2/spaces/{guid}/developers/{developer_guid}")
    Observable<Space> removeSpaceDeveloper(
            @Param("guid") UUID guid,
            @Param("developer_guid") UUID developerGuid
    );

    @RequestLine("GET /v2/spaces/{guid}/developers")
    Observable<User> getSpaceDevelopers(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/spaces/{guid}/developers?q={q}")
    Observable<User> getSpaceDevelopers(
            @Param("guid") UUID guid,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("PUT /v2/spaces/{guid}/managers/{manager_guid}")
    Observable<Space> addSpaceManager(
            @Param("guid") UUID guid,
            @Param("manager_guid") UUID managerGuid
    );

    @RequestLine("DELETE /v2/spaces/{guid}/managers/{manager_guid}")
    Observable<Space> removeSpaceManager(
            @Param("guid") UUID guid,
            @Param("manager_guid") UUID managerGuid
    );

    @RequestLine("GET /v2/spaces/{guid}/managers")
    Observable<User> getSpaceManagers(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/spaces/{guid}/managers?q={q}")
    Observable<User> getSpaceManagers(
            @Param("guid") UUID guid,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("POST /v2/spaces")
    @Body("%7B\"name\":\"{name}\", \"organization_guid\":\"{organization_guid}\"%7D")
    Observable<Space> createSpace(
            @Param("name") String name,
            @Param("organization_guid") UUID organizationGuid
    );

    @RequestLine("PUT /v2/spaces/{guid}")
    @Body("%7B\"name\":\"{name}\"%7D")
    Observable<Space> updateSpace(
            @Param("guid") UUID guid,
            @Param("name") String name
    );

    @RequestLine("DELETE /v2/spaces/{guid}")
    Observable<Response> deleteSpace(
            @Param("guid") UUID guid
    );

    @RequestLine("GET")
    Observable<Space> getSpaces(URI uri);

    @RequestLine("GET /v2/spaces")
    Observable<Space> getSpaces();

    @RequestLine("GET /v2/spaces/{guid}")
    Observable<Space> getSpaces(@Param("guid") UUID guid);
}
