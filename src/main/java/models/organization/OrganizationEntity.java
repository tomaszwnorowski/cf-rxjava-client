package models.organization;

import lombok.Data;

import java.net.URI;
import java.util.UUID;

@Data
public class OrganizationEntity {

    protected String name;
    protected boolean billingEnabled;
    protected UUID quotaDefinitionGuid;
    protected String status;
    protected URI quotaDefinitionUrl;
    protected URI spacesUrl;
    protected URI domainsUrl;
    protected URI privateDomainsUrl;
    protected URI usersUrl;
    protected URI managersUrl;
    protected URI billingManagersUrl;
    protected URI auditorsUrl;
    protected URI appEventsUrl;
    protected URI spaceQuotaDefinitionsUrl;

}
