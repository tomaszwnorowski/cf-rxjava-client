package models.service;

import lombok.Data;
import models.Metadata;

@Data
public class ServicePlan {

    protected Metadata metadata;
    protected ServicePlanEntity entity;

}
