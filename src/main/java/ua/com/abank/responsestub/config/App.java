package ua.com.abank.responsestub.config;

import java.util.List;

public class App {
    private String port;
    private List<Mapping> mappingsList;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public List<Mapping> getMappingsList() {
        return mappingsList;
    }

    public void setMappingsList(List<Mapping> mappingsList) {
        this.mappingsList = mappingsList;
    }
}
