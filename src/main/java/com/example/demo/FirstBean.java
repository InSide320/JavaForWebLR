package com.example.demo;

public class FirstBean {
    private SecondBean secondBean;

    public FirstBean() {
    }

    // Constructor-based DI
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
}
