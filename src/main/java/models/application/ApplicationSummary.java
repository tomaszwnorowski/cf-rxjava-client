package models.application;

import lombok.Data;
import models.summary.DomainSummary;
import models.summary.RouteSummary;
import models.summary.ServiceInstanceSummary;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class ApplicationSummary {

    protected UUID guid;
    protected String name;
    protected List<RouteSummary> routes;
    protected int runningInstances;
    protected List<ServiceInstanceSummary> services;
    protected List<DomainSummary> availableDomains;
    protected boolean production;
    protected UUID spaceGuid;
    protected UUID stackGuid;
    // TODO
    protected Object buildpack;
    // TODO
    protected Object detectedBuildpack;
    // TODO
    protected Object environmentJson;
    protected int memory;
    protected int instances;
    protected int diskQuota;
    protected ApplicationState state;
    protected UUID version;
    // TODO
    protected Object command;
    // TODO
    protected Object stagingTaskId;
    protected String packageState;
    protected String healthCheckType;
    // TODO
    protected Integer healthCheckTimeout;
    // TODO
    protected Object stagingFailedReason;
    // TODO
    protected Object stagingFailedDescription;
    protected boolean diego;
    // TODO
    protected Object dockerImage;
    protected Date packageUpdatedAt;
    // TODO
    protected String detectedStartCommand;
    protected boolean enableSsh;
    // TODO
    protected Object dockerCredentialsJson;

}
