package models.space;

import lombok.Data;
import models.Metadata;

@Data
public class SpaceQuotaDefinition {

    protected Metadata metadata;
    protected SpaceQuotaDefinitionEntity entity;

}
