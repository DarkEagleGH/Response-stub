package ua.com.abank.responsestub.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@EnableAutoConfiguration
@Configuration
public class AppConfigurer extends SpringBootServletInitializer {

    private final String MAIN_CONFIG = "config/AppConfig.json";

    public AppConfigurer(ObjectMapper objectMapper, Config config) {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode jsonNodeRoot = objectMapper.readTree(new FileInputStream(MAIN_CONFIG));
            config.setPort(jsonNodeRoot.get("port").asText());
            String mappings = jsonNodeRoot.get("mappings").asText();
            List<Mapping> mappingList;
            try {
                mappingList = objectMapper.readValue(mappings, new TypeReference<List<Mapping>>() {});
            } catch (Exception e) {
                e.printStackTrace();
                mappingList = Collections.emptyList();
            }
            Map<String, Mapping> mappingMap = Collections.emptyMap();
            for (Mapping mapping: mappingList) {
                mappingMap.put(mapping.getPath(), mapping);
            }
            config.setMappings(mappingMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
