package models.space;

import lombok.Data;
import models.Metadata;

@Data
public class Space {

    protected Metadata metadata;
    protected SpaceEntity entity;

}
