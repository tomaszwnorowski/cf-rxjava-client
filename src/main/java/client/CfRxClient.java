package client;

import feign.Feign;
import feign.Feign.Builder;
import feign.Logger;
import feign.RequestInterceptor;
import feign.Response;
import feign.codec.Decoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import models.*;
import operations.Organizations;
import operations.Services;
import operations.Spaces;
import queries.Query;
import rx.Observable;

import java.net.URI;
import java.util.Arrays;
import java.util.UUID;
import java.util.function.Function;

public class CfRxClient implements Organizations, Spaces, Services {
    private final Organizations organizations;
    private final Spaces spaces;
    private final Services services;

    public CfRxClient(CfConfig config) {
        this(config.getTarget(), new OAuth2RequestInterceptor(config.getAccessToken()));
    }

    public CfRxClient(String api) {
        this(api, Function.identity());
    }

    public CfRxClient(String api, RequestInterceptor... interceptors) {
        this(api, builder -> builder.requestInterceptors(Arrays.asList(interceptors)));
    }

    public CfRxClient(String api, Function<Builder, Builder> customizations) {
        organizations = customizations.apply(defaults(new CfRxDecoder<>(this::getOrganizations)))
                .target(Organizations.class, api);

        spaces = customizations.apply(defaults(new CfRxDecoder<>(this::getSpaces)))
                .target(Spaces.class, api);

        services = customizations.apply(defaults(new CfRxDecoder<>(this::getServices)))
                .target(Services.class, api);
    }

    private Builder defaults(Decoder decoder) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(decoder)
                .logger(new CfSlf4jLogger())
                .logLevel(Logger.Level.FULL);
    }

    /*****************
     * ORGANIZATIONS *
     *****************/

    @Override
    public Observable<Organization> addOrganizationAuditor(UUID guid, UUID auditorGuid) {
        return organizations.addOrganizationAuditor(guid, auditorGuid);
    }

    @Override
    public Observable<Organization> removeOrganizationAuditor(UUID guid, UUID auditorGuid) {
        return organizations.removeOrganizationAuditor(guid, auditorGuid);
    }

    @Override
    public Observable<User> getOrganizationAuditors(UUID guid) {
        return organizations.getOrganizationAuditors(guid);
    }

    @Override
    public Observable<User> getOrganizationAuditors(UUID guid, Query query) {
        return organizations.getOrganizationAuditors(guid, query);
    }

    @Override
    public Observable<Organization> addOrganizationBillingManager(UUID guid, UUID billingManagerGuid) {
        return organizations.addOrganizationBillingManager(guid, billingManagerGuid);
    }

    @Override
    public Observable<Organization> removeOrganizationBillingManager(UUID guid, UUID billingManagerGuid) {
        return organizations.removeOrganizationBillingManager(guid, billingManagerGuid);
    }

    @Override
    public Observable<User> getOrganizationBillingManagers(UUID guid) {
        return organizations.getOrganizationBillingManagers(guid);
    }

    @Override
    public Observable<User> getOrganizationBillingManagers(UUID guid, Query query) {
        return organizations.getOrganizationBillingManagers(guid, query);
    }

    @Override
    public Observable<Organization> addOrganizationManager(UUID guid, UUID managerGuid) {
        return organizations.addOrganizationManager(guid, managerGuid);
    }

    @Override
    public Observable<Organization> removeOrganizationManager(UUID guid, UUID managerGuid) {
        return organizations.removeOrganizationManager(guid, managerGuid);
    }

    @Override
    public Observable<User> getOrganizationManagers(UUID guid) {
        return organizations.getOrganizationManagers(guid);
    }

    @Override
    public Observable<User> getOrganizationManagers(UUID guid, Query query) {
        return organizations.getOrganizationManagers(guid, query);
    }

    @Override
    public Observable<Organization> addOrganizationPrivateDomain(UUID guid, UUID privateDomainGuid) {
        return organizations.addOrganizationPrivateDomain(guid, privateDomainGuid);
    }

    @Override
    public Observable<Organization> removeOrganizationPrivateDomain(UUID guid, UUID privateDomainGuid) {
        return organizations.removeOrganizationPrivateDomain(guid, privateDomainGuid);
    }

    @Override
    public Observable<PrivateDomain> getOrganizationPrivateDomains(UUID guid) {
        return organizations.getOrganizationPrivateDomains(guid);
    }

    @Override
    public Observable<PrivateDomain> getOrganizationPrivateDomains(UUID guid, Query query) {
        return organizations.getOrganizationPrivateDomains(guid, query);
    }

    @Override
    public Observable<Organization> addOrganizationUser(UUID guid, UUID userGuid) {
        return organizations.addOrganizationUser(guid, userGuid);
    }

    @Override
    public Observable<Organization> removeOrganizationUser(UUID guid, UUID userGuid) {
        return organizations.removeOrganizationUser(guid, userGuid);
    }

    @Override
    public Observable<User> getOrganizationUsers(UUID guid) {
        return organizations.getOrganizationUsers(guid);
    }

    @Override
    public Observable<User> getOrganizationUsers(UUID guid, Query query) {
        return organizations.getOrganizationUsers(guid, query);
    }

    @Override
    public Observable<Organization> createOrganization(String name) {
        return organizations.createOrganization(name);
    }

    @Override
    public Observable<Organization> updateOrganization(UUID guid, String name) {
        return organizations.updateOrganization(guid, name);
    }

    @Override
    public Observable<Response> deleteOrganization(UUID guid) {
        return organizations.deleteOrganization(guid);
    }

    @Override
    public Observable<InstanceUsage> getOrganizationInstanceUsage(UUID guid) {
        return organizations.getOrganizationInstanceUsage(guid);
    }

    @Override
    public Observable<MemoryUsage> getOrganizationMemoryUsage(UUID guid) {
        return organizations.getOrganizationMemoryUsage(guid);
    }

    @Override
    public Observable<OrganizationUser> getOrganizationUserRoles(UUID guid) {
        return organizations.getOrganizationUserRoles(guid);
    }

    @Override
    public Observable<OrganizationUser> getOrganizationUserRoles(UUID guid, Query query) {
        return organizations.getOrganizationUserRoles(guid, query);
    }

    @Override
    public Observable<Organization> getOrganizations() {
        return organizations.getOrganizations();
    }

    @Override
    public Observable<Organization> getOrganization(UUID guid) {
        return organizations.getOrganization(guid);
    }

    @Override
    public Observable<Organization> getOrganizations(URI uri) {
        return organizations.getOrganizations(uri);
    }

    @Override
    public Observable<Organization> getOrganizations(Query query) {
        return organizations.getOrganizations(query);
    }

    @Override
    public Observable<Space> getOrganizationSpaces(UUID guid) {
        return organizations.getOrganizationSpaces(guid);
    }

    @Override
    public Observable<Service> getOrganizationServices(UUID guid) {
        return organizations.getOrganizationServices(guid);
    }

    @Override
    public Observable<SpaceQuotaDefinition> getOrganizationSpaceQuotaDefinitions(UUID guid) {
        return organizations.getOrganizationSpaceQuotaDefinitions(guid);
    }

    /**********
     * SPACES *
     **********/

    @Override
    public Observable<Space> addSpaceAuditor(UUID guid, UUID auditorGuid) {
        return spaces.addSpaceAuditor(guid, auditorGuid);
    }

    @Override
    public Observable<Space> removeSpaceAuditor(UUID guid, UUID auditorGuid) {
        return spaces.removeSpaceAuditor(guid, auditorGuid);
    }

    @Override
    public Observable<User> getSpaceAuditors(UUID guid) {
        return spaces.getSpaceAuditors(guid);
    }

    @Override
    public Observable<User> getSpaceAuditors(UUID guid, Query query) {
        return spaces.getSpaceAuditors(guid, query);
    }

    @Override
    public Observable<Space> addSpaceDeveloper(UUID guid, UUID developerGuid) {
        return spaces.addSpaceDeveloper(guid, developerGuid);
    }

    @Override
    public Observable<Space> removeSpaceDeveloper(UUID guid, UUID developerGuid) {
        return spaces.removeSpaceDeveloper(guid, developerGuid);
    }

    @Override
    public Observable<User> getSpaceDevelopers(UUID guid) {
        return spaces.getSpaceDevelopers(guid);
    }

    @Override
    public Observable<User> getSpaceDevelopers(UUID guid, Query query) {
        return spaces.getSpaceDevelopers(guid, query);
    }

    @Override
    public Observable<Space> addSpaceManager(UUID guid, UUID managerGuid) {
        return spaces.addSpaceManager(guid, managerGuid);
    }

    @Override
    public Observable<Space> removeSpaceManager(UUID guid, UUID managerGuid) {
        return spaces.removeSpaceManager(guid, managerGuid);
    }

    @Override
    public Observable<User> getSpaceManagers(UUID guid) {
        return spaces.getSpaceManagers(guid);
    }

    @Override
    public Observable<User> getSpaceManagers(UUID guid, Query query) {
        return spaces.getSpaceManagers(guid, query);
    }

    @Override
    public Observable<Space> createSpace(String name, UUID organizationGuid) {
        return spaces.createSpace(name, organizationGuid);
    }

    @Override
    public Observable<Space> updateSpace(UUID guid, String name) {
        return spaces.updateSpace(guid, name);
    }

    @Override
    public Observable<Response> deleteSpace(UUID guid) {
        return spaces.deleteSpace(guid);
    }

    @Override
    public Observable<Space> getSpaces(URI uri) {
        return spaces.getSpaces(uri);
    }

    @Override
    public Observable<Space> getSpaces() {
        return spaces.getSpaces();
    }

    @Override
    public Observable<Space> getSpaces(UUID guid) {
        return spaces.getSpaces(guid);
    }

    /************
     * SERVICES *
     ************/

    @Override
    public Observable<Service> getServices(URI uri) {
        return services.getServices(uri);
    }

    @Override
    public Observable<Service> getServices() {
        return services.getServices();
    }

    @Override
    public Observable<Service> getServices(UUID guid) {
        return services.getServices(guid);
    }
}
