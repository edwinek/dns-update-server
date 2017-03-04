package uk.edwinek.dnsupdateserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("uk.edwinek.dnsupdateserver.security")
@PropertySource({"classpath:security.properties"})
public class WebSecurity {
}
