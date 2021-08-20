package com.nax.unloaderoc.models;

public class Case {

    String name, formFactor;
    double price;

    public Case(String name, String formFactor, double price) {
        this.name = name;
        this.formFactor = formFactor;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
