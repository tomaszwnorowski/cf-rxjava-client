package models.application;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class ApplicationUpdate {

    protected String name;
    protected UUID spaceGuid;
    protected UUID stackGuid;
    // TODO
    protected Object buildpack;
    // TODO
    protected Object environmentJson;
    protected int memory;
    protected int instances;
    protected int diskQuota;
    protected String state;
    // TODO
    protected Object command;
    // TODO
    protected Object stagingTaskId;
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
    // TODO
    protected String detectedStartCommand;

}
