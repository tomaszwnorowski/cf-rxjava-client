package models.space;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SpaceRole {
    SPACE_DEVELOPER,
    SPACE_MANAGER,
    SPACE_AUDITOR;

    @JsonCreator
    public SpaceRole fromString(String string) {
        for(SpaceRole role : values()) {
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
