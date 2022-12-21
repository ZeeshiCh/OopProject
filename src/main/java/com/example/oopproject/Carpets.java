package com.example.oopproject;

import java.io.Serializable;

public class Carpets implements Serializable {
    private String name;
    private double price;
    private String color;
    private String size;
    private int ID;
    private int stock;



    public Carpets(String name, double price, String color, String size, int ID, int stock) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.size = size;
        this.ID = ID;
        this.stock=stock;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public int getID() {
        return ID;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Carpets{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", ID=" + ID +
                ", stock=" + stock +
                '}';
    }


}
