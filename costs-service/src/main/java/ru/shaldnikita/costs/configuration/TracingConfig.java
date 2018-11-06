package ru.shaldnikita.costs.configuration;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author n.shaldenkov on 06.11.2018
 */
@Configuration
public class TracingConfig {

    @Bean
    @Profile("!prod")
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    @Bean
    @Profile("prod")
    public Sampler prodSampler() {
        return Sampler.create(0.7f);
    }
}
