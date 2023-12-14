package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "custom")
public class ThirdBean {
    private String message;

    public ThirdBean() {
    }

    // Constructor-based DI
    public ThirdBean(@Value("${custom.message}") String message) {
        this.message = message;
    }

    // Getter and Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Init method
    @PostConstruct
    public void init() {
        System.out.println("Initializing ThirdBean");
    }

    // Destroy method
    @PreDestroy
    public void destroy() {
        System.out.println("Destroying ThirdBean");
    }
}
