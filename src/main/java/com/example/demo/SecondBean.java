package com.example.demo;

public class SecondBean {
    private ThirdBean thirdBean;

    public SecondBean() {
    }

    // Constructor-based DI
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
}
