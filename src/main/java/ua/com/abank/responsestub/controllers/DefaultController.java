package ua.com.abank.responsestub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DefaultController extends AbstractErrorController {
    private static final String ERROR_PATH = "/error";

    @Autowired
    public DefaultController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping(ERROR_PATH)
    public ResponseEntity<?> errorResponse(HttpServletRequest request) {
        System.out.println(getErrorAttributes(request, false).get("path"));
        return new ResponseEntity(HttpStatus.valueOf(204));
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
