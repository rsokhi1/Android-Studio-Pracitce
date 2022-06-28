package com.example.multiscreen1;

import java.io.Serializable;

public class Car implements Serializable {
    private int year;
    private String model;
    private String color;
    private boolean isElectric;

    public Car(int year, String model, String color, boolean isElectric) {
        this.year = year;
        this.model = model;
        this.color = color;
        this.isElectric = isElectric;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", isElectric=" + isElectric +
                '}';
    }
}
