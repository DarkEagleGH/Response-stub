package ua.com.abank.responsestub.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

@Configuration
public class AppConfigurer {

    private final String MAIN_CONFIG = "config/AppConfig.json";
    private Config config;

    public AppConfigurer(ObjectMapper objectMapper, Config config) {
        this.config = config;
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        try {
            JsonNode rootNode = objectMapper.readTree(new FileInputStream(MAIN_CONFIG));
            config.setPort(rootNode.get("port").asInt());
            config.setDefaultCode(rootNode.get("defaultCode").asInt());
            System.getProperties().put("server.port", config.getPort());
            rootNode = rootNode.get("mappings");
            config.setMappings(objectMapper.readValue(rootNode.toString(),
                new TypeReference<Map<String, List<Mapping>>>() {}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Config getConfig() {
        return config;
    }
}
