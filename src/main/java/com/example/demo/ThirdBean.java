package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public class ThirdBean {
    @Value("${customs.message}")
    private String message;

    public ThirdBean() {
        this.setMessage(this.message);
    }

    // Constructor-based DI
    public ThirdBean(String message) {
        this.message = message;
    }

    // Getter and Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
