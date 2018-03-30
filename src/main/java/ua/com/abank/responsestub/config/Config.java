package ua.com.abank.responsestub.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class Config {

    @JsonIgnore
    private ObjectMapper objectMapper;
    private String port;
    private Map<String, List<Mapping>> mappings;

    public Config(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getPort() {
        return port;
    }

    void setPort(String port) {
        this.port = port;
    }

    public Map<String, List<Mapping>> getMappings() {
        return mappings;
    }

    void setMappings(Map<String, List<Mapping>> mappings) {
        this.mappings = mappings;
    }

    @Override
    public String toString() {
        ObjectNode resultNode = objectMapper.createObjectNode();
        resultNode.put("port", port);
        resultNode.putPOJO("mappings", mappings);
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resultNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
