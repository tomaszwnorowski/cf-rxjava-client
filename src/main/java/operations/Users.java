package operations;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import models.Organization;
import models.Space;
import models.User;
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

    @RequestLine("DELETE /v2/users/{user}/audited_organizations/{organization}")
    Observable<User> removeAuditedOrganization(
            @Param("user") UUID user,
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/users/{user}/audited_organizations")
    Observable<Organization> getAuditedOrganizations(
            @Param("user") UUID user
    );

    @RequestLine("PUT /v2/users/{user}/audited_spaces/{space}")
    Observable<User> addAuditedSpace(
            @Param("user") UUID user,
            @Param("space") UUID space
    );

    @RequestLine("DELETE /v2/users/{user}/audited_spaces/{space}")
    Observable<User> removeAuditedSpace(
            @Param("user") UUID user,
            @Param("space") UUID space
    );

    @RequestLine("GET /v2/users/{user}/audited_spaces")
    Observable<Space> getAuditedSpaces(
            @Param("user") UUID user
    );

    @RequestLine("PUT /v2/users/{user}/billing_managed_organizations/{organization}")
    Observable<User> addBillingManagedOrganization(
            @Param("user") UUID user,
            @Param("organization") UUID organization
    );

    @RequestLine("DELETE /v2/users/{user}/billing_managed_organizations/{organization}")
    Observable<User> removeBillingManagedOrganization(
            @Param("user") UUID user,
            @Param("organization") UUID organization
    );

    @RequestLine("GET /v2/users/{user}/billing_managed_organizations")
    Observable<Organization> getBillingManagedOrganizations(
            @Param("user") UUID user
    );

}
