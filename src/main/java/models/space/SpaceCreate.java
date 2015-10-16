package models.space;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Builder
@Data
public class SpaceCreate {

    protected String name;
    protected UUID organizationGuid;
    protected Set<UUID> developerGuids;
    protected Set<UUID> managerGuids;
    protected Set<UUID> auditorGuids;
    protected Set<UUID> domainGuids;
    protected Set<UUID> securityGroupGuids;
    protected UUID spaceQuotaDefinitionGuid;
    protected boolean allowSsh;

}
