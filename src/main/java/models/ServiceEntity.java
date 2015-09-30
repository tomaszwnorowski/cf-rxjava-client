package models;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ServiceEntity {

    protected String label;
    protected String description;
    protected boolean active;
    protected boolean bindable;
    protected Object extra;
    protected UUID uniqueId;
    protected List<String> tags;
    protected List<String> requires;
    protected UUID serviceBrokerGuid;
    protected boolean planUpdateable;

}
