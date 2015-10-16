package models.organization;

import lombok.Data;
import models.Metadata;
import models.organization.OrganizationEntity;

@Data
public class Organization {

    protected Metadata metadata;
    protected OrganizationEntity entity;

}
