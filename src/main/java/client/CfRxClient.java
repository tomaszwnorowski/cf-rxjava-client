package client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import feign.*;
import feign.Feign.Builder;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonEncoder;
import models.*;
import models.application.Application;
import models.application.ApplicationSummary;
import models.application.ApplicationUpdate;
import models.organization.Organization;
import models.organization.OrganizationSummary;
import models.organization.OrganizationUser;
import models.service.*;
import models.space.*;
import models.summary.SpaceSummary;
import models.user.User;
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
        final ObjectMapper mapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .setPropertyNamingStrategy(new PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy());

        final Encoder encoder = new JacksonEncoder(mapper);


        applications = customizations.apply(defaults(new CfRxDecoder<>(mapper, this::getApplications), encoder))
                .target(Applications.class, api);

        organizations = customizations.apply(defaults(new CfRxDecoder<>(mapper, this::getOrganizations), encoder))
                .target(Organizations.class, api);

        spaces = customizations.apply(defaults(new CfRxDecoder<>(mapper, this::getSpaces), encoder))
                .target(Spaces.class, api);

        services = customizations.apply(defaults(new CfRxDecoder<>(mapper, this::getServices), encoder))
                .target(Services.class, api);

        serviceInstances = customizations.apply(defaults(new CfRxDecoder<>(mapper, this::getServiceInstances), encoder))
                .target(ServiceInstances.class, api);

        users = customizations.apply(defaults(new CfRxDecoder<>(mapper, this::getUsers), encoder))
                .target(Users.class, api);
    }

    private Builder defaults(Decoder decoder, Encoder encoder) {
        return Feign.builder()
                .decoder(decoder)
                .encoder(encoder)
                .logger(new CfSlf4jLogger(CfRxClient.class))
                .logLevel(Logger.Level.FULL);
    }

    /************************************************************************************************
     * APPLICATIONS
     ************************************************************************************************/

    @Override
    public Observable<Application> getApplications(URI uri) {
        return applications.getApplications(uri);
    }

    @Override
    public Observable<Application> addApplicationRoute(UUID app, UUID route) {
        return applications.addApplicationRoute(app, route);
    }

    @Override
    public Observable<Response> deleteApplication(UUID app) {
        return applications.deleteApplication(app);
    }

    @Override
    public Observable<ApplicationSummary> getApplicationSummary(UUID app) {
        return applications.getApplicationSummary(app);
    }

    @Override
    public Observable<Application> getApplications() {
        return applications.getApplications();
    }

    @Override
    public Observable<Application> getApplications(UUID app) {
        return applications.getApplications(app);
    }

    @Override
    public Observable<Application> getApplications(Query query) {
        return applications.getApplications(query);
    }

    @Override
    public Observable<Route> getApplicationRoutes(UUID app) {
        return applications.getApplicationRoutes(app);
    }

    @Override
    public Observable<ServiceBinding> getApplicationServiceBindings(UUID app) {
        return applications.getApplicationServiceBindings(app);
    }

    @Override
    public Observable<Application> removeApplicationRoute(UUID app, UUID route) {
        return applications.removeApplicationRoute(app, route);
    }

    @Override
    public Observable<Application> removeApplicationServiceBinding(UUID app, UUID serviceBinding) {
        return applications.removeApplicationServiceBinding(app, serviceBinding);
    }

    @Override
    public Observable<Application> restageApplication(UUID app) {
        return applications.restageApplication(app);
    }

    @Override
    public Observable<Application> updateApplication(UUID app, ApplicationUpdate update) {
        return applications.updateApplication(app, update);
    }

    /************************************************************************************************
     * ORGANIZATIONS
     ************************************************************************************************/

    @Override
    public Observable<Organization> getOrganizations(URI uri) {
        return organizations.getOrganizations(uri);
    }

    @Override
    public Observable<Organization> addOrganizationAuditor(UUID organization, UUID user) {
        return organizations.addOrganizationAuditor(organization, user);
    }

    @Override
    public Observable<Organization> addOrganizationAuditor(UUID organization, String username) {
        return organizations.addOrganizationAuditor(organization, username);
    }

    @Override
    public Observable<Organization> addOrganizationBillingManager(UUID organization, UUID user) {
        return organizations.addOrganizationBillingManager(organization, user);
    }

    @Override
    public Observable<Organization> addOrganizationBillingManager(UUID organization, String username) {
        return organizations.addOrganizationBillingManager(organization, username);
    }

    @Override
    public Observable<Organization> addOrganizationManager(UUID organization, UUID user) {
        return organizations.addOrganizationManager(organization, user);
    }

    @Override
    public Observable<Organization> addOrganizationManager(UUID organization, String username) {
        return organizations.addOrganizationManager(organization, username);
    }

    @Override
    public Observable<Organization> addOrganizationPrivateDomain(UUID organization, UUID privateDomain) {
        return organizations.addOrganizationPrivateDomain(organization, privateDomain);
    }

    @Override
    public Observable<Organization> addOrganizationUser(UUID organization, UUID user) {
        return organizations.addOrganizationUser(organization, user);
    }

    @Override
    public Observable<Organization> addOrganizationUser(UUID organization, String username) {
        return organizations.addOrganizationUser(organization, username);
    }

    @Override
    public Observable<Organization> createOrganization(String name) {
        return organizations.createOrganization(name);
    }

    @Override
    public Observable<Response> deleteOrganization(UUID organization, boolean recursive, boolean async) {
        return organizations.deleteOrganization(organization, recursive, async);
    }

    @Override
    public Observable<Organization> removeOrganizationAuditor(UUID organization, UUID user) {
        return organizations.removeOrganizationAuditor(organization, user);
    }

    @Override
    public Observable<Organization> removeOrganizationAuditor(UUID organization, String username) {
        return organizations.removeOrganizationAuditor(organization, username);
    }

    @Override
    public Observable<Organization> removeOrganizationBillingManager(UUID organization, UUID user) {
        return organizations.removeOrganizationBillingManager(organization, user);
    }

    @Override
    public Observable<Organization> removeOrganizationBillingManager(UUID organization, String username) {
        return organizations.removeOrganizationBillingManager(organization, username);
    }

    @Override
    public Observable<Organization> removeOrganizationManager(UUID organization, UUID user) {
        return organizations.removeOrganizationManager(organization, user);
    }

    @Override
    public Observable<Organization> removeOrganizationManager(UUID organization, String username) {
        return organizations.removeOrganizationManager(organization, username);
    }

    @Override
    public Observable<Organization> removeOrganizationUser(UUID organization, UUID user) {
        return organizations.removeOrganizationUser(organization, user);
    }

    @Override
    public Observable<Organization> removeOrganizationUser(UUID organization, String username) {
        return organizations.removeOrganizationUser(organization, username);
    }

    @Override
    public Observable<OrganizationSummary> getOrganizationSummary(UUID organization) {
        return organizations.getOrganizationSummary(organization);
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
    public Observable<User> getOrganizationBillingManagers(UUID organization) {
        return organizations.getOrganizationBillingManagers(organization);
    }

    @Override
    public Observable<User> getOrganizationBillingManagers(UUID organization, Query query) {
        return organizations.getOrganizationBillingManagers(organization, query);
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
    public Observable<Organization> getOrganizations() {
        return organizations.getOrganizations();
    }

    @Override
    public Observable<Organization> getOrganizations(UUID organization) {
        return organizations.getOrganizations(organization);
    }

    @Override
    public Observable<Organization> getOrganizations(Query query) {
        return organizations.getOrganizations(query);
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
    public Observable<Service> getOrganizationServices(UUID organization) {
        return organizations.getOrganizationServices(organization);
    }

    @Override
    public Observable<Service> getOrganizationServices(UUID organization, Query query) {
        return organizations.getOrganizationServices(organization, query);
    }

    @Override
    public Observable<SpaceQuotaDefinition> getOrganizationSpaceQuotaDefinitions(UUID organization) {
        return organizations.getOrganizationSpaceQuotaDefinitions(organization);
    }

    @Override
    public Observable<SpaceQuotaDefinition> getOrganizationSpaceQuotaDefinitions(UUID organization, Query query) {
        return organizations.getOrganizationSpaceQuotaDefinitions(organization, query);
    }

    @Override
    public Observable<Space> getOrganizationSpaces(UUID organization) {
        return organizations.getOrganizationSpaces(organization);
    }

    @Override
    public Observable<Space> getOrganizationSpaces(UUID organization, Query query) {
        return organizations.getOrganizationSpaces(organization, query);
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
    public Observable<InstanceUsage> getOrganizationInstanceUsage(UUID organization) {
        return organizations.getOrganizationInstanceUsage(organization);
    }

    @Override
    public Observable<MemoryUsage> getOrganizationMemoryUsage(UUID organization) {
        return organizations.getOrganizationMemoryUsage(organization);
    }

    @Override
    public Observable<Organization> updateOrganization(UUID organization, String name) {
        return organizations.updateOrganization(organization, name);
    }

    @Override
    public Observable<Organization> removeOrganizationPrivateDomain(UUID organization, UUID privateDomain) {
        return organizations.removeOrganizationPrivateDomain(organization, privateDomain);
    }

    @Override
    public Observable<OrganizationUser> getOrganizationUserRoles(UUID organization) {
        return organizations.getOrganizationUserRoles(organization);
    }

    @Override
    public Observable<OrganizationUser> getOrganizationUserRoles(UUID organization, Query query) {
        return organizations.getOrganizationUserRoles(organization, query);
    }

    /************************************************************************************************
     * SPACES
     ************************************************************************************************/

    @Override
    public Observable<Space> getSpaces(URI uri) {
        return spaces.getSpaces(uri);
    }

    @Override
    public Observable<Space> addSpaceAuditor(UUID space, UUID user) {
        return spaces.addSpaceAuditor(space, user);
    }

    @Override
    public Observable<Space> addSpaceAuditor(UUID space, String username) {
        return spaces.addSpaceAuditor(space, username);
    }

    @Override
    public Observable<Space> addSpaceDeveloper(UUID space, UUID user) {
        return spaces.addSpaceDeveloper(space, user);
    }

    @Override
    public Observable<Space> addSpaceDeveloper(UUID space, String username) {
        return spaces.addSpaceDeveloper(space, username);
    }

    @Override
    public Observable<Space> addSpaceManager(UUID space, UUID user) {
        return spaces.addSpaceManager(space, user);
    }

    @Override
    public Observable<Space> addSpaceManager(UUID space, String username) {
        return spaces.addSpaceManager(space, username);
    }

    @Override
    public Observable<Space> addSpaceSecurityGroup(UUID space, UUID securityGroup) {
        return spaces.addSpaceSecurityGroup(space, securityGroup);
    }

    @Override
    public Observable<Space> createSpace(SpaceCreate create) {
        return spaces.createSpace(create);
    }

    @Override
    public Observable<Response> deleteSpace(UUID space, boolean recursive, boolean async) {
        return spaces.deleteSpace(space, recursive, async);
    }

    @Override
    public Observable<Space> removeSpaceAuditor(UUID space, UUID user) {
        return spaces.removeSpaceAuditor(space, user);
    }

    @Override
    public Observable<Space> removeSpaceAuditor(UUID space, String username) {
        return spaces.removeSpaceAuditor(space, username);
    }

    @Override
    public Observable<Space> removeSpaceDeveloper(UUID space, UUID user) {
        return spaces.removeSpaceDeveloper(space, user);
    }

    @Override
    public Observable<Space> removeSpaceDeveloper(UUID space, String username) {
        return spaces.removeSpaceDeveloper(space, username);
    }

    @Override
    public Observable<Space> removeSpaceManager(UUID space, UUID user) {
        return spaces.removeSpaceManager(space, user);
    }

    @Override
    public Observable<Space> removeSpaceManager(UUID space, String username) {
        return spaces.removeSpaceManager(space, username);
    }

    @Override
    public Observable<SpaceSummary> getSpaceSummary(UUID space) {
        return spaces.getSpaceSummary(space);
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
    public Observable<User> getSpaceAuditors(UUID space) {
        return spaces.getSpaceAuditors(space);
    }

    @Override
    public Observable<User> getSpaceAuditors(UUID space, Query query) {
        return spaces.getSpaceAuditors(space, query);
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
    public Observable<SecurityGroup> getSpaceSecurityGroups(UUID space) {
        return spaces.getSpaceSecurityGroups(space);
    }

    @Override
    public Observable<SecurityGroup> getSpaceSecurityGroups(UUID space, Query query) {
        return spaces.getSpaceSecurityGroups(space, query);
    }

    @Override
    public Observable<ServiceInstance> getSpaceServiceInstances(UUID space) {
        return spaces.getSpaceServiceInstances(space);
    }

    @Override
    public Observable<ServiceInstance> getSpaceServiceInstances(UUID space, Query query) {
        return spaces.getSpaceServiceInstances(space, query);
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
    public Observable<Space> getSpaces() {
        return spaces.getSpaces();
    }

    @Override
    public Observable<Space> getSpaces(UUID space) {
        return spaces.getSpaces(space);
    }

    @Override
    public Observable<Space> getSpaces(Query query) {
        return spaces.getSpaces(query);
    }

    @Override
    public Observable<Space> removeSpaceSecurityGroup(UUID space, UUID securityGroup) {
        return spaces.removeSpaceSecurityGroup(space, securityGroup);
    }

    @Override
    public Observable<SpaceUser> getSpaceUserRoles(UUID space) {
        return spaces.getSpaceUserRoles(space);
    }

    @Override
    public Observable<Space> updateSpace(UUID space, SpaceUpdate update) {
        return spaces.updateSpace(space, update);
    }

    /************************************************************************************************
     * SERVICES
     ************************************************************************************************/

    @Override
    public Observable<Service> getServices(URI uri) {
        return services.getServices(uri);
    }

    @Override
    public Observable<Response> deleteService(UUID service) {
        return services.deleteService(service);
    }

    @Override
    public Observable<ServicePlan> getServicePlans(UUID service) {
        return services.getServicePlans(service);
    }

    @Override
    public Observable<ServicePlan> getServicePlans(UUID service, Query query) {
        return services.getServicePlans(service, query);
    }

    @Override
    public Observable<Service> getServices() {
        return services.getServices();
    }

    @Override
    public Observable<Service> getServices(UUID service) {
        return services.getServices(service);
    }

    @Override
    public Observable<Service> getServices(Query query) {
        return services.getServices(query);
    }

    /************************************************************************************************
     * SERVICE INSTANCES
     ************************************************************************************************/

    @Override
    public Observable<ServiceInstance> getServiceInstances(URI uri) {
        return serviceInstances.getServiceInstances(uri);
    }

    @Override
    public Observable<ServiceInstance> createServiceInstance(ServiceInstanceCreate create) {
        return serviceInstances.createServiceInstance(create);
    }

    @Override
    public Observable<ServiceInstance> deleteServiceInstance(UUID serviceInstance) {
        return serviceInstances.deleteServiceInstance(serviceInstance);
    }

    @Override
    public Observable<Route> getServiceInstanceRoutes(UUID serviceInstance) {
        return serviceInstances.getServiceInstanceRoutes(serviceInstance);
    }

    @Override
    public Observable<ServiceBinding> getServiceInstanceBindings(UUID serviceInstance) {
        return serviceInstances.getServiceInstanceBindings(serviceInstance);
    }

    @Override
    public Observable<ServiceInstance> getServiceInstances() {
        return serviceInstances.getServiceInstances();
    }

    @Override
    public Observable<ServiceInstance> getServiceInstances(UUID serviceInstance) {
        return serviceInstances.getServiceInstances(serviceInstance);
    }

    @Override
    public Observable<ServiceInstance> getServiceInstances(Query query) {
        return serviceInstances.getServiceInstances(query);
    }

    @Override
    public Observable<ServiceInstance> updateServiceInstance(UUID serviceInstance, ServiceInstanceUpdate update) {
        return serviceInstances.updateServiceInstance(serviceInstance, update);
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
    public Observable<User> addAuditedSpace(UUID user, UUID space) {
        return users.addAuditedSpace(user, space);
    }

    @Override
    public Observable<User> addBillingManagedOrganization(UUID user, UUID organization) {
        return users.addBillingManagedOrganization(user, organization);
    }

    @Override
    public Observable<User> addManagedOrganization(UUID user, UUID organization) {
        return users.addManagedOrganization(user, organization);
    }

    @Override
    public Observable<User> addManagedSpace(UUID user, UUID space) {
        return users.addManagedSpace(user, space);
    }

    @Override
    public Observable<User> addOrganization(UUID user, UUID organization) {
        return users.addOrganization(user, organization);
    }

    @Override
    public Observable<User> addSpace(UUID user, UUID space) {
        return users.addSpace(user, space);
    }

    @Override
    public Observable<Organization> getAuditedOrganizations(UUID user) {
        return users.getAuditedOrganizations(user);
    }

    @Override
    public Observable<Organization> getBillingManagedOrganizations(UUID user) {
        return users.getBillingManagedOrganizations(user);
    }

    @Override
    public Observable<Space> getAuditedSpaces(UUID user) {
        return users.getAuditedSpaces(user);
    }

    @Override
    public Observable<User> getUsers() {
        return users.getUsers();
    }

    @Override
    public Observable<User> getUsers(UUID user) {
        return users.getUsers(user);
    }

    @Override
    public Observable<User> getUsers(Query query) {
        return users.getUsers(query);
    }

    @Override
    public Observable<User> removeAuditedOrganization(UUID user, UUID organization) {
        return users.removeAuditedOrganization(user, organization);
    }

    @Override
    public Observable<User> removeAuditedSpace(UUID user, UUID space) {
        return users.removeAuditedSpace(user, space);
    }

    @Override
    public Observable<User> removeBillingManagedOrganization(UUID user, UUID organization) {
        return users.removeBillingManagedOrganization(user, organization);
    }
}
