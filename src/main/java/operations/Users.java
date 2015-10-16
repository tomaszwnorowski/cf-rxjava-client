package operations;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import models.organization.Organization;
import models.space.Space;
import models.user.User;
import queries.Query;
import queries.QueryExpander;
import rx.Observable;

import java.net.URI;
import java.util.UUID;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface Users {

    @RequestLine("GET")
    Observable<User> getUsers(URI uri);

    @RequestLine("PUT /v2/users/{user}/audited_organizations/{organization}")
    Observable<User> addAuditedOrganization(
            @Param("user") UUID user,
            @Param("organization") UUID organization
    );

    @RequestLine("PUT /v2/users/{user}/audited_spaces/{space}")
    Observable<User> addAuditedSpace(
            @Param("user") UUID user,
            @Param("space") UUID space
    );

    @RequestLine("PUT /v2/users/{user}/billing_managed_organizations/{organization}")
    Observable<User> addBillingManagedOrganization(
            @Param("user") UUID user,
            @Param("organization") UUID organization
    );

    @RequestLine("PUT /v2/users/{user}/managed_organizations/{organization}")
    Observable<User> addManagedOrganization(
            @Param("user") UUID user,
            @Param("organization") UUID organization
    );

    @RequestLine("PUT /v2/users/{user}/managed_spaces/{space}")
    Observable<User> addManagedSpace(
            @Param("user") UUID user,
            @Param("space") UUID space
    );

    @RequestLine("PUT /v2/users/{user}/organizations/{organization}")
    Observable<User> addOrganization(
            @Param("user") UUID user,
            @Param("organization") UUID organization
    );

    @RequestLine("PUT /v2/users/{user}/spaces/{space}")
    Observable<User> addSpace(
            @Param("user") UUID user,
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/users/{user}/audited_organizations")
    Observable<Organization> getAuditedOrganizations(
            @Param("user") UUID user
    );

    @RequestLine("GET /v2/users/{user}/billing_managed_organizations")
    Observable<Organization> getBillingManagedOrganizations(
            @Param("user") UUID user
    );

    @RequestLine("GET /v2/users/{user}/audited_spaces")
    Observable<Space> getAuditedSpaces(
            @Param("user") UUID user
    );

    @RequestLine("GET /v2/users")
    Observable<User> getUsers();

    @RequestLine("GET /v2/users/{user}")
    Observable<User> getUsers(
            @Param("user") UUID user
    );

    @RequestLine("GET /v2/users?q={q}")
    Observable<User> getUsers(
            @Param(value = "q", expander = QueryExpander.class) Query query
    );

    @RequestLine("DELETE /v2/users/{user}/audited_organizations/{organization}")
    Observable<User> removeAuditedOrganization(
            @Param("user") UUID user,
            @Param("organization") UUID organization
    );

    @RequestLine("DELETE /v2/users/{user}/audited_spaces/{space}")
    Observable<User> removeAuditedSpace(
            @Param("user") UUID user,
            @Param("space") UUID space
    );

    @RequestLine("DELETE /v2/users/{user}/billing_managed_organizations/{organization}")
    Observable<User> removeBillingManagedOrganization(
            @Param("user") UUID user,
            @Param("organization") UUID organization
    );

}
