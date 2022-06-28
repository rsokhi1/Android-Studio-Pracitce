package com.example.manipulatingcustomobj;

public class Country {
    //properties
    private String name;
    private double population;
    private String capitalCity;

    //constructor
    public Country(String name, double population, String capitalCity) {
        this.name = name;
        this.population = population;
        this.capitalCity = capitalCity;
    }

    // getter and setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", capitalCity='" + capitalCity + '\'' +
                '}';
    }
}