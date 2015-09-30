package client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class OAuth2ClientConfig {
    private final ObjectMapper mapper = new ObjectMapper();
    private final Map<String, Object> properties;

    public OAuth2ClientConfig() {
        this(new File(System.getenv("CF_HOME"), "config.json"));
    }

    public OAuth2ClientConfig(File file) {
        try {
            this.properties = mapper.readValue(file, new TypeReference<Map<String,Object>>(){});
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid configuration file: " + file, e);
        }
    }

    public String getTarget() {
        return properties.get("Target").toString();
    }

    public String getAccessToken() {
        return properties.get("AccessToken").toString().split(" ")[1];
    }
}
