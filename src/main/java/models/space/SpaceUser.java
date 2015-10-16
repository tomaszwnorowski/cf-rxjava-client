package models.space;

import lombok.Data;
import models.Metadata;

@Data
public class SpaceUser {

    protected Metadata metadata;
    protected SpaceUserEntity entity;

}
