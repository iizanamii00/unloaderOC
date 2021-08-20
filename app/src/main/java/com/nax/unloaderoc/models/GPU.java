package com.nax.unloaderoc.models;

public class GPU {

    String name;
    double price, TDP;

    public GPU(String name, double price, double TDP) {
        this.name = name;
        this.price = price;
        this.TDP = TDP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTDP() {
        return TDP;
    }

    public void setTDP(double TDP) {
        this.TDP = TDP;
    }
}
