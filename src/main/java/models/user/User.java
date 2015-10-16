package models.user;

import lombok.Data;
import models.Metadata;

@Data
public class User {

    protected Metadata metadata;
    protected UserEntity entity;

}
