package ua.com.abank.responsestub.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

@Configuration
public class AppConfigurer {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
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
        } catch (Exception exception) {
            LOGGER.error("Can't read config. ", exception);
            LOGGER.error("Set default port: 3000, response code: 200");
            try {
                config.setPort(3000);
                config.setDefaultCode(200);
            } catch (Exception innerException) {
                LOGGER.error("Can't set defaults. ", innerException);
            }
        }
    }

    Config getConfig() {
        return config;
    }
}
