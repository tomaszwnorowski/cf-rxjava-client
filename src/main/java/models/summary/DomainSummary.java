package models.summary;

import lombok.Data;

import java.util.UUID;

@Data
public class DomainSummary {

    protected UUID guid;
    protected String name;

}
