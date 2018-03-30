package ua.com.abank.responsestub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.com.abank.responsestub.config.AppConfigurer;

@EnableAutoConfiguration
@SpringBootApplication
public class ResponseStubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResponseStubApplication.class, args);
    }
}
