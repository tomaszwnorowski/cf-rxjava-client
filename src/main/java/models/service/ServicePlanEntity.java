package models.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.util.UUID;

@Data
public class ServicePlanEntity {

    protected String name;
    protected boolean free;
    protected String description;
    protected UUID serviceGuid;
    // TODO
    protected Object extra;
    protected UUID uniqueId;
    protected boolean active;
    protected URI serviceUrl;
    protected URI serviceInstancesUrl;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    protected boolean _public;

    @JsonProperty("public")
    public boolean isPublic() {
        return _public;
    }

    @JsonProperty("public")
    public void setPublic(boolean _public) {
        this._public = _public;
    }

}
