package models.summary;

import lombok.Data;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
public class ApplicationSummary {

    protected UUID guid;
    protected List<URI> urls;
    protected List<RouteSummary> routes;
    protected int serviceCount;
    protected Set<String> serviceNames;
    protected int runningInstances;
    protected String name;
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
    protected String state;
    protected UUID version;
    // TODO
    protected Object command;
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
