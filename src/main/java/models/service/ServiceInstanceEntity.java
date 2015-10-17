package models.service;

import lombok.Data;
import models.LastOperation;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@Data
public class ServiceInstanceEntity {

    protected String name;
    protected Object credentials;
    protected UUID servicePlanGuid;
    protected UUID spaceGuid;
    protected URI dashboardUrl;
    protected String type;
    protected LastOperation lastOperation;
    protected Set<String> tags;
    protected URI spaceUrl;
    protected URI servicePlanUrl;
    protected URI serviceBindingsUrl;
    protected URI serviceKeysUrl;
    protected URI routesUrl;

}
