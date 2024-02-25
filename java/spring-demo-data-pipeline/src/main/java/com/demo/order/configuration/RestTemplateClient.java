package com.demo.order.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The type Rest template client.
 */
@Configuration
public class RestTemplateClient {
    /**
     * Rest template local rest template.
     *
     * @return the rest template
     */
    @Bean
    public RestTemplate restTemplateLocal() {
        return new RestTemplate();
    }
}