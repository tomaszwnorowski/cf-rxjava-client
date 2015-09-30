package models;

import lombok.Data;

import java.net.URI;
import java.util.UUID;

@Data
public class UserEntity {

    protected boolean admin;
    protected boolean active;
    protected UUID defaultSpaceGuid;
    protected String username;
    protected URI spacesUrl;
    protected URI organizationsUrl;
    protected URI managedOrganizationsUrl;
    protected URI billingManagedOrganizationsUrl;
    protected URI auditedOrganizationsUrl;
    protected URI managedSpacesUrl;
    protected URI auditedSpacesUrl;

}
