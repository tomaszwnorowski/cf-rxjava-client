package models.summary;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class SpaceSummary {

    protected UUID guid;
    protected String name;
    protected List<ApplicationSummary> apps;
    protected List<ServiceInstanceSummary> services;

}
