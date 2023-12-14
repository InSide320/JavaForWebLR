package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SecondBean {
    private ThirdBean thirdBean;

    public SecondBean() {
    }

    // Constructor-based DI
    @Autowired
    public SecondBean(ThirdBean thirdBean) {
        this.thirdBean = thirdBean;
    }

    // Getter and Setter
    public ThirdBean getThirdBean() {
        return thirdBean;
    }

    public void setThirdBean(ThirdBean thirdBean) {
        this.thirdBean = thirdBean;
    }

    // Init method
    @PostConstruct
    public void init() {
        System.out.println("Initializing SecondBean");
    }

    // Destroy method
    @PreDestroy
    public void destroy() {
        System.out.println("Destroying SecondBean");
    }
}
