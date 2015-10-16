package models.service;

import lombok.Data;

import java.net.URI;
import java.util.UUID;

@Data
public class ServiceBindingEntity {

    protected UUID appGuid;
    protected UUID serviceInstanceGuid;
    // TODO
    protected Object credentials;
    // TODO
    protected Object bindingOptions;
    // TODO
    protected Object gatewayData;
    // TODO
    protected String gatewayName;
    protected URI syslogDrainUrl;
    protected URI appUrl;
    protected URI serviceInstanceUrl;

}
