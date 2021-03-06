package ua.com.abank.responsestub.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.abank.responsestub.config.Config;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorController extends AbstractErrorController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private Config config;
    private final String ERROR_PATH = "/error";

    @Autowired
    public ErrorController(Config config, ErrorAttributes errorAttributes) {
        super(errorAttributes);
        this.config = config;
    }

    @RequestMapping(ERROR_PATH)
    public ResponseEntity<?> errorResponse(HttpServletRequest request) {
        LOGGER.info("Remote host: " + request.getRemoteHost() + ", Requested method: " + request.getMethod()
                + ", Requested URI: " + request.getRequestURI());
        return new ResponseEntity(HttpStatus.valueOf(config.getDefaultCode()));
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
