package ua.com.abank.responsestub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import ua.com.abank.responsestub.config.AppConfigurer;

@EnableAutoConfiguration
@SpringBootApplication
public class ResponseStubApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ResponseStubApplication.class, args);
    }
}
