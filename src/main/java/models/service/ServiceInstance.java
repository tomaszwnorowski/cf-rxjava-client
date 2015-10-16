package models.service;

import lombok.Data;
import models.Metadata;

@Data
public class ServiceInstance {

    protected Metadata metadata;
    protected ServiceInstanceEntity entity;

}
