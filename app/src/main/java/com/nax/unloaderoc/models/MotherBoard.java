package com.nax.unloaderoc.models;

public class MotherBoard {

    String name;
    String socket;
    String formFactor;
    double price;

    public MotherBoard(String name, String socket, String formFactor, double price) {
        this.formFactor = formFactor;
        this.name = name;
        this.price = price;
        this.socket = socket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
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
