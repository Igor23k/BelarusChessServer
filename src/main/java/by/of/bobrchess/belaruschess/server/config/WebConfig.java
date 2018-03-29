package by.of.bobrchess.belaruschess.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("by.of.bobrchess.belaruschess.server")
public class WebConfig implements WebMvcConfigurer {
}
