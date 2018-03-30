package ua.com.abank.responsestub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ResponseStubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResponseStubApplication.class, args);
    }
}
