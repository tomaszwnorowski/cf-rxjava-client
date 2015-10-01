package client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class CfConfig {
    private static final String CF_HOME = "CF_HOME";
    private static final String TARGET = "Target";
    private static final String ACCESS_TOKEN = "AccessToken";
    private final Map<String, Object> properties;

    public CfConfig() {
        this(Paths.get(System.getProperty(CF_HOME, System.getenv(CF_HOME)), ".cf", "config.json"));
    }

    public CfConfig(Path configPath) {
        try {
            this.properties = new ObjectMapper()
                    .readValue(configPath.toFile(), new TypeReference<Map<String, Object>>(){});
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid configuration file: " + configPath, e);
        }
    }

    public String getTarget() {
        return properties.get(TARGET).toString();
    }

    public String getAccessToken() {
        return properties.get(ACCESS_TOKEN).toString().split(" ")[1];
    }
}
