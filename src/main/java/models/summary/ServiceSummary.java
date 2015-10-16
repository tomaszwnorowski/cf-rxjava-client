package models.summary;

import lombok.Data;

import java.util.UUID;

@Data
public class ServiceSummary {

    protected UUID guid;
    protected String label;
    // TODO
    protected Object provider;
    // TODO
    protected Object version;

}
