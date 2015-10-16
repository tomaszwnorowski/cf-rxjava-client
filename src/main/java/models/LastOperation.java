package models;

import lombok.Data;

import java.util.Date;

@Data
public class LastOperation {

    protected String type;
    protected String state;
    protected String description;
    protected Date updatedAt;
    protected Date createdAt;

}
