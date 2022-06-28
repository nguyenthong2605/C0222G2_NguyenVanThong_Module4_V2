package com.codegym.song.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
@Configuration
public class AppConfig {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
// Thay tên bundle chưa message vào method dưới.
        messageSource.setBasenames("msg/error_message");
        return messageSource;
    }
}
