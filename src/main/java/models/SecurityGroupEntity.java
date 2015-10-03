package models;

import lombok.Data;

import java.net.URI;
import java.util.List;

@Data
public class SecurityGroupEntity {

    protected String name;
    // TODO
    protected List<Object> rules;
    protected boolean runningDefault;
    protected boolean stagingDefault;
    protected URI spacesUrl;

}
