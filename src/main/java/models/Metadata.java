package models;

import lombok.Data;

import java.net.URI;
import java.util.Date;
import java.util.UUID;

@Data
public class Metadata {

    protected UUID guid;
    protected URI url;
    protected Date createdAt;
    protected Date updatedAt;

}
