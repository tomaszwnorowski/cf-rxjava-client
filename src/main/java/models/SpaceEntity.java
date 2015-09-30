package models;

import lombok.Data;

import java.net.URI;
import java.util.UUID;

@Data
public class SpaceEntity {

    protected String name;
    protected UUID organizationGuid;
    protected UUID spaceQuotaDefinitionGuid;
    protected boolean allowSsh;
    protected URI organizationUrl;
    protected URI developersUrl;
    protected URI managersUrl;
    protected URI auditorsUrl;
    protected URI appsUrl;
    protected URI routesUrl;
    protected URI domainsUrl;
    protected URI serviceInstancesUrl;
    protected URI appEventsUrl;
    protected URI events_url;
    protected URI security_groups_url;

}
