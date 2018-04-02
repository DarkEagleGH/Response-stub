package ua.com.abank.responsestub.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class CustomizedServlet implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    private int port;

    CustomizedServlet(AppConfigurer appConfigurer) {
        this.port = appConfigurer.getConfig().getPort();
    }

    @Override
    public void customize(ConfigurableServletWebServerFactory container) {
        container.setPort(port);
        Properties props = System.getProperties();
        props.setProperty("Logback.configurationFile", "http://gate.ac.uk/wiki/code-repository");
    }
}
