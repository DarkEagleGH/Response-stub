package ua.com.abank.responsestub.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.abank.responsestub.config.Config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CustomController {
    private Config config;

    public CustomController(Config config) {
        this.config = config;
    }

    @RequestMapping("/ffff")
    public ResponseEntity getResponse(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURI());
        System.out.println(config.toString());
        return new ResponseEntity(HttpStatus.valueOf(200));
    }
}
