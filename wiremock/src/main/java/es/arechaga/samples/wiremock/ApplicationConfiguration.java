package es.arechaga.samples.wiremock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    RestTemplate buildRestTemplate() {
        return new RestTemplate();
    }
}
