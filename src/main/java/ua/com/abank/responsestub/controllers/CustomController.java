package ua.com.abank.responsestub.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CustomController {

    @RequestMapping("/ffff")
    public ResponseEntity index(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURI());
        return new ResponseEntity(HttpStatus.valueOf(200));
    }
}
