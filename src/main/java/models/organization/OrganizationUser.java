package models.organization;

import lombok.Data;
import models.Metadata;

@Data
public class OrganizationUser {

    protected Metadata metadata;
    protected OrganizationUserEntity entity;

}
