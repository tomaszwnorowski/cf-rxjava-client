package client;

import feign.Feign;
import feign.Feign.Builder;
import feign.Logger;
import feign.RequestInterceptor;
import feign.Response;
import feign.codec.Decoder;
import feign.jackson.JacksonEncoder;
import models.*;
import operations.*;
import queries.Query;
import rx.Observable;

import java.net.URI;
import java.util.Arrays;
import java.util.UUID;
import java.util.function.Function;

public class CfRxClient implements Applications, Organizations, Spaces, Services, ServiceInstances, Users {
    private final Applications applications;
    private final Organizations organizations;
    private final Spaces spaces;
    private final Services services;
    private final ServiceInstances serviceInstances;
    private final Users users;

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
        applications = customizations.apply(defaults(new CfRxDecoder<>(this::getApplications)))
                .target(Applications.class, api);

        organizations = customizations.apply(defaults(new CfRxDecoder<>(this::getOrganizations)))
                .target(Organizations.class, api);

        spaces = customizations.apply(defaults(new CfRxDecoder<>(this::getSpaces)))
                .target(Spaces.class, api);

        services = customizations.apply(defaults(new CfRxDecoder<>(this::getServices)))
                .target(Services.class, api);

        serviceInstances = customizations.apply(defaults(new CfRxDecoder<>(this::getServiceInstances)))
                .target(ServiceInstances.class, api);

        users = customizations.apply(defaults(new CfRxDecoder<>(this::getUsers)))
                .target(Users.class, api);
    }

    private Builder defaults(Decoder decoder) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(decoder)
                .logger(new CfSlf4jLogger())
                .logLevel(Logger.Level.BASIC);
    }

    /************************************************************************************************
     * APPLICATIONS
     ************************************************************************************************/

    @Override
    public Observable<Application> getApplications(URI uri) {
        return applications.getApplications(uri);
    }

    /************************************************************************************************
     * ORGANIZATIONS
     ************************************************************************************************/

    @Override
    public Observable<Organization> getOrganizations(URI uri) {
        return organizations.getOrganizations(uri);
    }

    @Override
    public Observable<Organization> createOrganization(String name) {
        return organizations.createOrganization(name);
    }

    @Override
    public Observable<Organization> updateOrganization(UUID organization, String name) {
        return organizations.updateOrganization(organization, name);
    }

    @Override
    public Observable<Response> deleteOrganization(UUID organization) {
        return organizations.deleteOrganization(organization);
    }

    @Override
    public Observable<Organization> addOrganizationAuditor(UUID organization, UUID user) {
        return organizations.addOrganizationAuditor(organization, user);
    }

    @Override
    public Observable<Organization> removeOrganizationAuditor(UUID organization, UUID user) {
        return organizations.removeOrganizationAuditor(organization, user);
    }

    @Override
    public Observable<User> getOrganizationAuditors(UUID organization) {
        return organizations.getOrganizationAuditors(organization);
    }

    @Override
    public Observable<User> getOrganizationAuditors(UUID organization, Query query) {
        return organizations.getOrganizationAuditors(organization, query);
    }

    @Override
    public Observable<Organization> addOrganizationBillingManager(UUID organization, UUID user) {
        return organizations.addOrganizationBillingManager(organization, user);
    }

    @Override
    public Observable<Organization> removeOrganizationBillingManager(UUID organization, UUID user) {
        return organizations.removeOrganizationBillingManager(organization, user);
    }

    @Override
    public Observable<User> getOrganizationBillingManagers(UUID organization) {
        return organizations.getOrganizationBillingManagers(organization);
    }

    @Override
    public Observable<User> getOrganizationBillingManagers(UUID organization, Query query) {
        return organizations.getOrganizationBillingManagers(organization, query);
    }

    @Override
    public Observable<Organization> addOrganizationManager(UUID organization, UUID user) {
        return organizations.addOrganizationManager(organization, user);
    }

    @Override
    public Observable<Organization> removeOrganizationManager(UUID organization, UUID user) {
        return organizations.removeOrganizationManager(organization, user);
    }

    @Override
    public Observable<User> getOrganizationManagers(UUID organization) {
        return organizations.getOrganizationManagers(organization);
    }

    @Override
    public Observable<User> getOrganizationManagers(UUID organization, Query query) {
        return organizations.getOrganizationManagers(organization, query);
    }

    @Override
    public Observable<Organization> addOrganizationPrivateDomain(UUID organization, UUID privateDomain) {
        return organizations.addOrganizationPrivateDomain(organization, privateDomain);
    }

    @Override
    public Observable<Organization> removeOrganizationPrivateDomain(UUID organization, UUID privateDomain) {
        return organizations.removeOrganizationPrivateDomain(organization, privateDomain);
    }

    @Override
    public Observable<PrivateDomain> getOrganizationPrivateDomains(UUID organization) {
        return organizations.getOrganizationPrivateDomains(organization);
    }

    @Override
    public Observable<PrivateDomain> getOrganizationPrivateDomains(UUID organization, Query query) {
        return organizations.getOrganizationPrivateDomains(organization, query);
    }

    @Override
    public Observable<Organization> addOrganizationUser(UUID organization, UUID user) {
        return organizations.addOrganizationUser(organization, user);
    }

    @Override
    public Observable<Organization> removeOrganizationUser(UUID organization, UUID user) {
        return organizations.removeOrganizationUser(organization, user);
    }

    @Override
    public Observable<User> getOrganizationUsers(UUID organization) {
        return organizations.getOrganizationUsers(organization);
    }

    @Override
    public Observable<User> getOrganizationUsers(UUID organization, Query query) {
        return organizations.getOrganizationUsers(organization, query);
    }

    @Override
    public Observable<OrganizationSummary> getOrganizationSummary(UUID organization) {
        return organizations.getOrganizationSummary(organization);
    }

    @Override
    public Observable<InstanceUsage> getOrganizationInstanceUsage(UUID organization) {
        return organizations.getOrganizationInstanceUsage(organization);
    }

    @Override
    public Observable<MemoryUsage> getOrganizationMemoryUsage(UUID organization) {
        return organizations.getOrganizationMemoryUsage(organization);
    }

    @Override
    public Observable<OrganizationUser> getOrganizationUserRoles(UUID organization) {
        return organizations.getOrganizationUserRoles(organization);
    }

    @Override
    public Observable<OrganizationUser> getOrganizationUserRoles(UUID organization, Query query) {
        return organizations.getOrganizationUserRoles(organization, query);
    }

    @Override
    public Observable<SpaceQuotaDefinition> getOrganizationSpaceQuotaDefinitions(UUID organization) {
        return organizations.getOrganizationSpaceQuotaDefinitions(organization);
    }

    @Override
    public Observable<Organization> getOrganizations() {
        return organizations.getOrganizations();
    }

    @Override
    public Observable<Organization> getOrganizations(Query query) {
        return organizations.getOrganizations(query);
    }

    @Override
    public Observable<Organization> getOrganization(UUID organization) {
        return organizations.getOrganization(organization);
    }

    @Override
    public Observable<Space> getOrganizationSpaces(UUID organization) {
        return organizations.getOrganizationSpaces(organization);
    }

    @Override
    public Observable<Service> getOrganizationServices(UUID organization) {
        return organizations.getOrganizationServices(organization);
    }

    /************************************************************************************************
     * SPACES
     ************************************************************************************************/

    @Override
    public Observable<Space> getSpaces(URI uri) {
        return spaces.getSpaces(uri);
    }

    @Override
    public Observable<Space> createSpace(String name, UUID organization) {
        return spaces.createSpace(name, organization);
    }

    @Override
    public Observable<Space> updateSpace(UUID space, String name) {
        return spaces.updateSpace(space, name);
    }

    @Override
    public Observable<Response> deleteSpace(UUID space) {
        return spaces.deleteSpace(space);
    }

    @Override
    public Observable<Space> addSpaceAuditor(UUID space, UUID user) {
        return spaces.addSpaceAuditor(space, user);
    }

    @Override
    public Observable<Space> removeSpaceAuditor(UUID space, UUID user) {
        return spaces.removeSpaceAuditor(space, user);
    }

    @Override
    public Observable<User> getSpaceAuditors(UUID space) {
        return spaces.getSpaceAuditors(space);
    }

    @Override
    public Observable<User> getSpaceAuditors(UUID space, Query query) {
        return spaces.getSpaceAuditors(space, query);
    }

    @Override
    public Observable<Space> addSpaceDeveloper(UUID space, UUID user) {
        return spaces.addSpaceDeveloper(space, user);
    }

    @Override
    public Observable<Space> removeSpaceDeveloper(UUID space, UUID user) {
        return spaces.removeSpaceDeveloper(space, user);
    }

    @Override
    public Observable<User> getSpaceDevelopers(UUID space) {
        return spaces.getSpaceDevelopers(space);
    }

    @Override
    public Observable<User> getSpaceDevelopers(UUID space, Query query) {
        return spaces.getSpaceDevelopers(space, query);
    }

    @Override
    public Observable<Space> addSpaceManager(UUID space, UUID user) {
        return spaces.addSpaceManager(space, user);
    }

    @Override
    public Observable<Space> removeSpaceManager(UUID space, UUID user) {
        return spaces.removeSpaceManager(space, user);
    }

    @Override
    public Observable<User> getSpaceManagers(UUID space) {
        return spaces.getSpaceManagers(space);
    }

    @Override
    public Observable<User> getSpaceManagers(UUID space, Query query) {
        return spaces.getSpaceManagers(space, query);
    }

    @Override
    public Observable<Route> getSpaceRoutes(UUID space) {
        return spaces.getSpaceRoutes(space);
    }

    @Override
    public Observable<Route> getSpaceRoutes(UUID space, Query query) {
        return spaces.getSpaceRoutes(space, query);
    }

    @Override
    public Observable<Space> addSpaceSecurityGroup(UUID space, UUID securityGroup) {
        return spaces.addSpaceSecurityGroup(space, securityGroup);
    }

    @Override
    public Observable<Space> removeSpaceSecurityGroup(UUID space, UUID securityGroup) {
        return spaces.removeSpaceSecurityGroup(space, securityGroup);
    }

    @Override
    public Observable<SecurityGroup> getSpaceSecurityGroups(UUID space) {
        return spaces.getSpaceSecurityGroups(space);
    }

    @Override
    public Observable<SecurityGroup> getSpaceSecurityGroups(UUID space, Query query) {
        return spaces.getSpaceSecurityGroups(space, query);
    }

    @Override
    public Observable<Application> getSpaceApplications(UUID space) {
        return spaces.getSpaceApplications(space);
    }

    @Override
    public Observable<Application> getSpaceApplications(UUID space, Query query) {
        return spaces.getSpaceApplications(space, query);
    }

    @Override
    public Observable<Service> getSpaceServices(UUID space) {
        return spaces.getSpaceServices(space);
    }

    @Override
    public Observable<Service> getSpaceServices(UUID space, Query query) {
        return spaces.getSpaceServices(space, query);
    }

    @Override
    public Observable<Service> getSpaceServiceInstances(UUID space) {
        return spaces.getSpaceServiceInstances(space);
    }

    @Override
    public Observable<Service> getSpaceServiceInstances(UUID space, Query query) {
        return spaces.getSpaceServiceInstances(space, query);
    }

    @Override
    public Observable<Space> getSpaces() {
        return spaces.getSpaces();
    }

    @Override
    public Observable<Space> getSpaces(Query query) {
        return spaces.getSpaces(query);
    }

    @Override
    public Observable<Space> getSpaces(UUID space) {
        return spaces.getSpaces(space);
    }

    /************************************************************************************************
     * SERVICES
     ************************************************************************************************/

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

    /************************************************************************************************
     * SERVICE INSTANCES
     ************************************************************************************************/

    @Override
    public Observable<ServiceInstance> getServiceInstances(URI uri) {
        return serviceInstances.getServiceInstances(uri);
    }

    /************************************************************************************************
     * USERS
     ************************************************************************************************/

    @Override
    public Observable<User> getUsers(URI uri) {
        return users.getUsers(uri);
    }

    @Override
    public Observable<User> addAuditedOrganization(UUID user, UUID organization) {
        return users.addAuditedOrganization(user, organization);
    }

    @Override
    public Observable<User> removeAuditedOrganization(UUID user, UUID organization) {
        return users.removeAuditedOrganization(user, organization);
    }

    @Override
    public Observable<Organization> getAuditedOrganizations(UUID user) {
        return users.getAuditedOrganizations(user);
    }

    @Override
    public Observable<User> addAuditedSpace(UUID user, UUID space) {
        return users.addAuditedSpace(user, space);
    }

    @Override
    public Observable<User> removeAuditedSpace(UUID user, UUID space) {
        return users.removeAuditedSpace(user, space);
    }

    @Override
    public Observable<Space> getAuditedSpaces(UUID user) {
        return users.getAuditedSpaces(user);
    }

    @Override
    public Observable<User> addBillingManagedOrganization(UUID user, UUID organization) {
        return users.addBillingManagedOrganization(user, organization);
    }

    @Override
    public Observable<User> removeBillingManagedOrganization(UUID user, UUID organization) {
        return users.removeBillingManagedOrganization(user, organization);
    }

    @Override
    public Observable<Organization> getBillingManagedOrganizations(UUID user) {
        return users.getBillingManagedOrganizations(user);
    }
}
