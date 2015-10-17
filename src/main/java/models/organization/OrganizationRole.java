package models.organization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrganizationRole {
    ORG_USER,
    ORG_MANAGER,
    ORG_AUDITOR,
    BILLING_MANAGER;

    @JsonCreator
    public OrganizationRole fromString(String string) {
        for(OrganizationRole role : values()) {
            if(role.name().equalsIgnoreCase(string)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + string);
    }

    @JsonValue
    public String toJson() {
        return name().toLowerCase();
    }
}
