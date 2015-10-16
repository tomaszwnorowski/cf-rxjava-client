package models.service;

import lombok.Builder;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Builder
public class ServiceInstanceUpdate {

    protected String name;
    protected UUID servicePlanGuid;
    protected Map<String, Object> parameters;
    protected Set<String> tags;

}
