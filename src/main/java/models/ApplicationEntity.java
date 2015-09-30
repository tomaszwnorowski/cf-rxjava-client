package models;

import lombok.Data;

import java.net.URI;
import java.util.Date;
import java.util.UUID;

@Data
public class ApplicationEntity {

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
    protected String version;
    // TODO
    protected Object command;
    // TODO
    protected Object debug;
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
    protected URI spaceUrl;
    protected URI stackUrl;
    protected URI eventsUrl;
    protected URI serviceBindingsUrl;
    protected URI routesUrl;

}
