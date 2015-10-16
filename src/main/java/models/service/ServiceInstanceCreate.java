package models.service;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Builder
@Data
public class ServiceInstanceCreate {

    protected String name;
    protected UUID servicePlanGuid;
    protected UUID spaceGuid;
    protected Map<String, Object> parameters;
    protected Set<String> tags;

}
