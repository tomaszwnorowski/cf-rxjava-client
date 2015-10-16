package models.space;

import lombok.Data;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@Data
public class SpaceUserEntity {

    protected boolean admin;
    protected boolean active;
    protected UUID defaultSpaceGuid;
    protected String username;
    protected Set<String> spaceRoles;
    protected URI spacesUrl;
    protected URI organizationsUrl;
    protected URI managedOrganizationsUrl;
    protected URI billingManagedOrganizationsUrl;
    protected URI auditedOrganizationsUrl;
    protected URI managedSpacesUrl;
    protected URI auditedSpacesUrl;

}
