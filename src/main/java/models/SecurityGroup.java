package models;

import lombok.Data;

@Data
public class SecurityGroup {

    protected Metadata metadata;
    protected SecurityGroupEntity entity;

}
