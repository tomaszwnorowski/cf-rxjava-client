package models;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrganizationSummary {

    protected UUID guid;
    protected String name;
    protected String status;
    protected List<OrganizationSummarySpace> spaces;

}
