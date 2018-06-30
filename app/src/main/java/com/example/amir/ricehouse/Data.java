package com.example.amir.ricehouse;

public class Data {

    private String description;
    private float rate;
    private String title;
    private double price;

    public double getRate() {return rate;}
    public String getDescription() {return description;}
    public double getPrice() {return price;}
    public String getTitle() {return title;}

    public void setDescription(String description) {
        this.description = description;
    }
    public void setRate(float rate) {
        this.rate = rate;
    }
    public void setTitle(String title) {this.title = title;}
    public void setPrice(double price) {this.price = price;}
}
