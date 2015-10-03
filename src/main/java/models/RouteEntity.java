package models;

import lombok.Data;

import java.net.URI;
import java.util.UUID;

@Data
public class RouteEntity {

    protected String host;
    protected String path;
    protected UUID domainGuid;
    protected UUID spaceGuid;
    protected UUID serviceInstanceGuid;
    protected URI domainUrl;
    protected URI spaceUrl;
    protected URI appsUrl;

}
