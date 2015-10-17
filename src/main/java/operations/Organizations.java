package operations;

import feign.*;
import models.*;
import models.organization.Organization;
import models.organization.OrganizationSummary;
import models.organization.OrganizationUser;
import models.service.Service;
import models.space.Space;
import models.space.SpaceQuotaDefinition;
import models.user.User;
import queries.Query;
import queries.V2QueryExpander;
import rx.Observable;

import java.net.URI;
import java.util.UUID;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface Organizations {

    @RequestLine("GET")
    Observable<Organization> getOrganizations(URI uri);

    @RequestLine("PUT /v2/organizations/{organization}/auditors/{user}")
    Observable<Organization> addOrganizationAuditor(
            @Param("organization") UUID organization,
            @Param("user") UUID user
    );

    @RequestLine("PUT /v2/organizations/{organization}/auditors")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Organization> addOrganizationAuditor(
            @Param("organization") UUID organization,
            @Param("username") String username
    );

    @RequestLine("PUT /v2/organizations/{organization}/billing_managers/{user}")
    Observable<Organization> addOrganizationBillingManager(
            @Param("organization") UUID organization,
            @Param("user") UUID user
    );

    @RequestLine("PUT /v2/organizations/{organization}/billing_managers")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Organization> addOrganizationBillingManager(
            @Param("organization") UUID organization,
            @Param("username") String username
    );

    @RequestLine("PUT /v2/organizations/{organization}/managers/{user}")
    Observable<Organization> addOrganizationManager(
            @Param("organization") UUID organization,
            @Param("user") UUID user
    );

    @RequestLine("PUT /v2/organizations/{organization}/managers")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Organization> addOrganizationManager(
            @Param("organization") UUID organization,
            @Param("username") String username
    );

    @RequestLine("PUT /v2/organizations/{organization}/private_domains/{private_domain}")
    Observable<Organization> addOrganizationPrivateDomain(
            @Param("organization") UUID organization,
            @Param("private_domain") UUID privateDomain
    );

    @RequestLine("PUT /v2/organizations/{organization}/users/{user}")
    Observable<Organization> addOrganizationUser(
            @Param("organization") UUID organization,
            @Param("user") UUID user
    );

    @RequestLine("PUT /v2/organizations/{organization}/users")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Organization> addOrganizationUser(
            @Param("organization") UUID organization,
            @Param("username") String username
    );

    @RequestLine("POST /v2/organizations")
    @Body("%7B\"name\":\"{name}\"%7D")
    Observable<Organization> createOrganization(
            @Param("name") String name
    );

    @RequestLine("DELETE /v2/organizations/{organization}?recursive={recursive}&async={async}")
    Observable<Response> deleteOrganization(
            @Param("organization") UUID organization,
            @Param("recursive") boolean recursive,
            @Param("async") boolean async
    );

    @RequestLine("DELETE /v2/organizations/{organization}/auditors/{user}")
    Observable<Organization> removeOrganizationAuditor(
            @Param("organization") UUID organization,
            @Param("user") UUID user
    );

    @RequestLine("DELETE /v2/organizations/{organization}/auditors")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Organization> removeOrganizationAuditor(
            @Param("organization") UUID organization,
            @Param("username") String username
    );

    @RequestLine("DELETE /v2/organizations/{organization}/billing_managers/{user}")
    Observable<Organization> removeOrganizationBillingManager(
            @Param("organization") UUID organization,
            @Param("user") UUID user
    );

    @RequestLine("DELETE /v2/organizations/{organization}/billing_managers")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Organization> removeOrganizationBillingManager(
            @Param("organization") UUID organization,
            @Param("username") String username
    );

    @RequestLine("DELETE /v2/organizations/{organization}/managers/{user}")
    Observable<Organization> removeOrganizationManager(
            @Param("organization") UUID organization,
            @Param("user") UUID user
    );

    @RequestLine("DELETE /v2/organizations/{organization}/managers")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Organization> removeOrganizationManager(
            @Param("organization") UUID organization,
            @Param("username") String username
    );

    @RequestLine("DELETE /v2/organizations/{organization}/users/{user}")
    Observable<Organization> removeOrganizationUser(
            @Param("organization") UUID organization,
            @Param("user") UUID user
    );

    @RequestLine("DELETE /v2/organizations/{organization}/users")
    @Body("%7B\"username\":\"{username}\"%7D")
    Observable<Organization> removeOrganizationUser(
            @Param("organization") UUID organization,
            @Param("username") String username
    );

    @RequestLine("GET /v2/organizations/{organization}/summary")
    Observable<OrganizationSummary> getOrganizationSummary(
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations/{organization}/auditors")
    Observable<User> getOrganizationAuditors(
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations/{organization}/auditors?q={q}")
    Observable<User> getOrganizationAuditors(
            @Param("organization") UUID organization,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/organizations/{organization}/billing_managers")
    Observable<User> getOrganizationBillingManagers(
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations/{organization}/billing_managers?q={q}")
    Observable<User> getOrganizationBillingManagers(
            @Param("organization") UUID organization,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/organizations/{organization}/managers")
    Observable<User> getOrganizationManagers(
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations/{organization}/managers?q={q}")
    Observable<User> getOrganizationManagers(
            @Param("organization") UUID organization,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/organizations")
    Observable<Organization> getOrganizations();

    @RequestLine("GET /v2/organizations/{organization}")
    Observable<Organization> getOrganizations(
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations?q={q}")
    Observable<Organization> getOrganizations(
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/organizations/{organization}/private_domains")
    Observable<PrivateDomain> getOrganizationPrivateDomains(
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations/{organization}/private_domains?q={q}")
    Observable<PrivateDomain> getOrganizationPrivateDomains(
            @Param("organization") UUID organization,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/organizations/{organization}/services")
    Observable<Service> getOrganizationServices(
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations/{organization}/services?q={q}")
    Observable<Service> getOrganizationServices(
            @Param("organization") UUID organization,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/organizations/{organization}/space_quota_definitions")
    Observable<SpaceQuotaDefinition> getOrganizationSpaceQuotaDefinitions(
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations/{organization}/space_quota_definitions?q={q}")
    Observable<SpaceQuotaDefinition> getOrganizationSpaceQuotaDefinitions(
            @Param("organization") UUID organization,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/organizations/{organization}/spaces")
    Observable<Space> getOrganizationSpaces(
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations/{organization}/spaces?q={q}")
    Observable<Space> getOrganizationSpaces(
            @Param("organization") UUID organization,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/organizations/{organization}/users")
    Observable<User> getOrganizationUsers(
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations/{organization}/users?q={q}")
    Observable<User> getOrganizationUsers(
            @Param("organization") UUID organization,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/organizations/{organization}/instance_usage")
    Observable<InstanceUsage> getOrganizationInstanceUsage(
        @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations/{organization}/memory_usage")
    Observable<MemoryUsage> getOrganizationMemoryUsage(
            @Param("organization") UUID organization
    );

    @RequestLine("PUT /v2/organizations/{organization}")
    @Body("%7B\"name\":\"{name}\"%7D")
    Observable<Organization> updateOrganization(
            @Param("organization") UUID organization,
            @Param("name") String name
    );

    @RequestLine("DELETE /v2/organizations/{organization}/private_domains/{private_domain}")
    Observable<Organization> removeOrganizationPrivateDomain(
            @Param("organization") UUID organization,
            @Param("private_domain") UUID privateDomain
    );

    @RequestLine("GET /v2/organizations/{organization}/user_roles")
    Observable<OrganizationUser> getOrganizationUserRoles(
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/organizations/{organization}/user_roles?q={q}")
    Observable<OrganizationUser> getOrganizationUserRoles(
            @Param("organization") UUID organization,
            @Param(value = "q", expander = V2QueryExpander.class) Query query
    );
}
