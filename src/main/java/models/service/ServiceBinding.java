package models.service;

import lombok.Data;
import models.Metadata;

@Data
public class ServiceBinding {

    protected Metadata metadata;
    protected ServiceBindingEntity entity;

}
