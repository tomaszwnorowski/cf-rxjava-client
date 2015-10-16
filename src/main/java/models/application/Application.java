package models.application;

import lombok.Data;
import models.Metadata;

@Data
public class Application {

    protected Metadata metadata;
    protected ApplicationEntity entity;

}
