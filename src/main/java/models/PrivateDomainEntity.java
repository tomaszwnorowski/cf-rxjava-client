package models;

import lombok.Data;

import java.net.URI;
import java.util.UUID;

@Data
public class PrivateDomainEntity {

    protected String name;
    protected UUID owningOrganizationGuid;
    protected URI owningOrganizationUrl;
    protected URI sharedOrganizationsUrl;

}
