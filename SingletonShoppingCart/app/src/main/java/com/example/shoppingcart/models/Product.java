package com.example.shoppingcart.models;

public class Product {
    private int id;
    private String name;
    private String desc;
    private double price;
    private int quantityRemaining;

    public Product(int id, String name, String desc, double price, int quantityRemaining) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.quantityRemaining = quantityRemaining;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", quantityRemaining=" + quantityRemaining +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityRemaining() {
        return quantityRemaining;
    }

    public void setQuantityRemaining(int quantityRemaining) {
        this.quantityRemaining = quantityRemaining;
    }

}
