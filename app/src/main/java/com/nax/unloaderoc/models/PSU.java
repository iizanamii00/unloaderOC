package com.nax.unloaderoc.models;

public class PSU {

    String name;
    double wattage, price;

    public PSU(String name, double wattage, double price) {
        this.name = name;
        this.wattage = wattage;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
