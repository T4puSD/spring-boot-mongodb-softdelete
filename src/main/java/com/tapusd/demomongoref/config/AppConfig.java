package com.tapusd.demomongoref.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@EnableMongoAuditing
public class AppConfig {

    /**
     * Enabling schema validation with hibernate validator during save event
     */
    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener(final LocalValidatorFactoryBean validatorFactoryBean) {
        return new ValidatingMongoEventListener(validatorFactoryBean);
    }
}
