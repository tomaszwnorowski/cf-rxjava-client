package models.summary;

import lombok.Data;

import java.util.UUID;

@Data
public class RouteSummary {

    protected UUID guid;
    protected String host;
    protected DomainSummary domain;

}
