package models;

import lombok.Data;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@Data
public class ServiceInstanceEntity {

    protected String name;
    // TODO
    protected Object credentials;
    protected UUID servicePlanGuid;
    protected UUID spaceGuid;
    protected URI dashboardUrl;
    protected String type;
    // TODO
    protected Object lastOperation;
    protected Set<String> tags;
    protected URI spaceUrl;
    protected URI servicePlanUrl;
    protected URI serviceBindingsUrl;
    protected URI serviceKeysUrl;
    protected URI routesUrl;

}
