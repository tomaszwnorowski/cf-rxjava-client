package models.summary;

import lombok.Data;
import models.LastOperation;

import java.net.URI;
import java.util.UUID;

@Data
public class ServiceInstanceSummary {

    protected UUID guid;
    protected String name;
    protected int boundAppCount;
    protected LastOperation lastOperation;
    protected URI dashboardUrl;
    protected ServicePlanSummary servicePlan;

}
