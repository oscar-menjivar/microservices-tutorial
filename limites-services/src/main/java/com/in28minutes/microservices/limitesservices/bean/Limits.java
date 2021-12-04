package com.in28minutes.microservices.limitesservices.bean;

public class Limits {

    private int minumun;
    private int maximun;

    public Limits(){}

    public Limits(int minumun, int maximun) {
        this.minumun = minumun;
        this.maximun = maximun;
    }

    public int getMinumun() {
        return minumun;
    }

    public void setMinumun(int minumun) {
        this.minumun = minumun;
    }

    public int getMaximun() {
        return maximun;
    }

    public void setMaximun(int maximun) {
        this.maximun = maximun;
    }
}
