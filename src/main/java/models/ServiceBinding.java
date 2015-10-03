package models;

import lombok.Data;

@Data
public class ServiceBinding {

    protected Metadata metadata;
    protected ServiceBindingEntity entity;

}
