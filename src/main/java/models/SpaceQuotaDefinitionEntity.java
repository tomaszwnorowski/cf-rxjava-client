package models;

import lombok.Data;

import java.net.URI;
import java.util.UUID;

@Data
public class SpaceQuotaDefinitionEntity {

    protected String name;
    protected UUID organizationGuid;
    protected boolean nonBasicServicesAllowed;
    protected int totalServices;
    protected int totalRouts;
    protected int memoryLimit;
    protected int instanceMemoryLimit;
    protected URI organizationUrl;
    protected URI spacesUrl;

}
