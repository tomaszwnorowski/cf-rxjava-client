package models.service;

import lombok.Data;
import models.Metadata;

@Data
public class Service {

    protected Metadata metadata;
    protected ServiceEntity entity;

}
