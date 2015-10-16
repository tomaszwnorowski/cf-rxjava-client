package models.summary;

import lombok.Data;

import java.util.UUID;

@Data
public class ServicePlanSummary {

    protected UUID guid;
    protected String name;
    protected ServiceSummary service;

}
