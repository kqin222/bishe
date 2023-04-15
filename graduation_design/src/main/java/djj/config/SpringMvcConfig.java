package djj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"djj.controller","djj.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
