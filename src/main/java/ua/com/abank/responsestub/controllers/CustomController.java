package ua.com.abank.responsestub.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.abank.responsestub.config.Config;
import ua.com.abank.responsestub.config.Mapping;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.net.URLClassLoader;

@RestController
public class CustomController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private Config config;

    public CustomController(Config config) {
        this.config = config;
    }

    private ResponseEntity findRoute(String method, String path) {
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        if (config.getMappings().containsKey(method)) {
            for (Mapping mapping : config.getMappings().get(method)) {
                if (mapping.getPath().equals(path)) {
                    return new ResponseEntity<>(mapping.getBody(), HttpStatus.valueOf(mapping.getCode()));
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.valueOf(config.getDefaultCode()));
    }

    @RequestMapping(value = "**")
    public ResponseEntity getMethodResponse(HttpServletRequest request) {
        LOGGER.info("Remote host: " + request.getRemoteHost() + ", Requested method: " + request.getMethod()
                + ", Requested URI: " + request.getRequestURI());
        return findRoute(request.getMethod(), request.getRequestURI());
    }
}
