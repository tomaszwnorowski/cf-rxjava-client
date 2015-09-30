package operations;

import feign.*;
import models.*;
import queries.Query;
import queries.QueryExpander;
import rx.Observable;

import java.net.URI;
import java.util.UUID;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface Organizations {

    @RequestLine("PUT /v2/organizations/{guid}/auditors/{auditor_guid}")
    Observable<Organization> addOrganizationAuditor(
            @Param("guid") UUID guid,
            @Param("auditor_guid") UUID auditorGuid
    );

    @RequestLine("DELETE /v2/organizations/{guid}/auditors/{auditor_guid}")
    Observable<Organization> removeOrganizationAuditor(
            @Param("guid") UUID guid,
            @Param("auditor_guid") UUID auditorGuid
    );

    @RequestLine("GET /v2/organizations/{guid}/auditors")
    Observable<User> getOrganizationAuditors(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/auditors?q={q}")
    Observable<User> getOrganizationAuditors(
            @Param("guid") UUID guid,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("PUT /v2/organizations/{guid}/billing_managers/{billing_manager_guid}")
    Observable<Organization> addOrganizationBillingManager(
            @Param("guid") UUID guid,
            @Param("billing_manager_guid") UUID billingManagerGuid
    );

    @RequestLine("DELETE /v2/organizations/{guid}/billing_managers/{billing_manager_guid}")
    Observable<Organization> removeOrganizationBillingManager(
            @Param("guid") UUID guid,
            @Param("billing_manager_guid") UUID billingManagerGuid
    );

    @RequestLine("GET /v2/organizations/{guid}/billing_managers")
    Observable<User> getOrganizationBillingManagers(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/billing_managers?q={q}")
    Observable<User> getOrganizationBillingManagers(
            @Param("guid") UUID guid,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("PUT /v2/organizations/{guid}/managers/{manager_guid}")
    Observable<Organization> addOrganizationManager(
            @Param("guid") UUID guid,
            @Param("manager_guid") UUID managerGuid
    );

    @RequestLine("DELETE /v2/organizations/{guid}/managers/{manager_guid}")
    Observable<Organization> removeOrganizationManager(
            @Param("guid") UUID guid,
            @Param("manager_guid") UUID managerGuid
    );

    @RequestLine("GET /v2/organizations/{guid}/managers")
    Observable<User> getOrganizationManagers(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/managers?q={q}")
    Observable<User> getOrganizationManagers(
            @Param("guid") UUID guid,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("PUT /v2/organizations/{guid}/private_domains/{private_domain_guid}")
    Observable<Organization> addOrganizationPrivateDomain(
            @Param("guid") UUID guid,
            @Param("private_domain_guid") UUID privateDomainGuid
    );

    @RequestLine("DELETE /v2/organizations/{guid}/private_domains/{private_domain_guid}")
    Observable<Organization> removeOrganizationPrivateDomain(
            @Param("guid") UUID guid,
            @Param("private_domain_guid") UUID privateDomainGuid
    );

    @RequestLine("GET /v2/organizations/{guid}/private_domains")
    Observable<PrivateDomain> getOrganizationPrivateDomains(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/private_domains?q={q}")
    Observable<PrivateDomain> getOrganizationPrivateDomains(
            @Param("guid") UUID guid,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("PUT /v2/organizations/{guid}/users/{user_guid}")
    Observable<Organization> addOrganizationUser(
            @Param("guid") UUID guid,
            @Param("user_guid") UUID userGuid
    );

    @RequestLine("DELETE /v2/organizations/{guid}/users/{user_guid}")
    Observable<Organization> removeOrganizationUser(
            @Param("guid") UUID guid,
            @Param("user_guid") UUID userGuid
    );

    @RequestLine("GET /v2/organizations/{guid}/users")
    Observable<User> getOrganizationUsers(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/users?q={q}")
    Observable<User> getOrganizationUsers(
            @Param("guid") UUID guid,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("POST /v2/organizations")
    @Body("%7B\"name\":\"{name}\"%7D")
    Observable<Organization> createOrganization(
            @Param("name") String name
    );

    @RequestLine("PUT /v2/organizations/{guid}")
    @Body("%7B\"name\":\"{name}\"%7D")
    Observable<Organization> updateOrganization(
            @Param("guid") UUID guid,
            @Param("name") String name
    );

    @RequestLine("DELETE /v2/organizations/{guid}")
    Observable<Response> deleteOrganization(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/instance_usage")
    Observable<InstanceUsage> getOrganizationInstanceUsage(
        @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/memory_usage")
    Observable<MemoryUsage> getOrganizationMemoryUsage(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/user_roles")
    Observable<OrganizationUser> getOrganizationUserRoles(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/user_roles?q={q}")
    Observable<OrganizationUser> getOrganizationUserRoles(
            @Param("guid") UUID guid,
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("GET")
    Observable<Organization> getOrganizations(URI uri);

    @RequestLine("GET /v2/organizations")
    Observable<Organization> getOrganizations();

    @RequestLine("GET /v2/organizations?q={q}")
    Observable<Organization> getOrganizations(
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("GET /v2/organizations/{guid}")
    Observable<Organization> getOrganization(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/space_quota_definitions")
    Observable<SpaceQuotaDefinition> getOrganizationSpaceQuotaDefinitions(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/spaces")
    Observable<Space> getOrganizationSpaces(
            @Param("guid") UUID guid
    );

    @RequestLine("GET /v2/organizations/{guid}/services")
    Observable<Service> getOrganizationServices(
            @Param("guid") UUID guid
    );

}
