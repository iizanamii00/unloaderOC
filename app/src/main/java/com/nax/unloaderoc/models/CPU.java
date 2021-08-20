package com.nax.unloaderoc.models;

public class CPU {

    String name;
    String socket;
    double price, TDP;

    public CPU(String name, String socket, double price, double TDP) {
        this.name = name;
        this.socket = socket;
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

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }
}
