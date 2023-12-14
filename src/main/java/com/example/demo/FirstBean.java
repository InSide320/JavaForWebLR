package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class FirstBean {
    private SecondBean secondBean;

    public FirstBean() {
    }

    // Constructor-based DI
    @Autowired
    public FirstBean(SecondBean secondBean) {
        this.secondBean = secondBean;
    }

    // Getter and Setter
    public SecondBean getSecondBean() {
        return secondBean;
    }

    public void setSecondBean(SecondBean secondBean) {
        this.secondBean = secondBean;
    }

    // Init method
    @PostConstruct
    public void init() {
        System.out.println("Initializing FirstBean");
    }

    // Destroy method
    @PreDestroy
    public void destroy() {
        System.out.println("Destroying FirstBean");
    }
}

