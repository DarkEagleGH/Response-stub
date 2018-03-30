package ua.com.abank.responsestub.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

@Configuration
@JsonAutoDetect
public class Config {
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
        try {
            ObjectNode rootNode = objectMapper.createObjectNode();
            rootNode.put("port", this.port);
            ArrayNode mappingsNode = objectMapper.createArrayNode();
            for (Mapping mapping: mappings.values()) {
                mappingsNode.add(objectMapper.createObjectNode().putPOJO(mapping.getPath(), mapping));
            }

            final ByteArrayOutputStream out = new ByteArrayOutputStream();

            mapper.writeValue(out, list);

            mappings.forEach((s, mappingsList) -> mappingsList.);
            rootNode.putArray("mappings").addAll(mappingsNode);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
