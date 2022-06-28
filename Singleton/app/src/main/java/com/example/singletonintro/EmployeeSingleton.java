package com.example.singletonintro;

public class EmployeeSingleton {
    private static EmployeeSingleton instance = null;

    public static EmployeeSingleton getInstance(){
        if(instance == null){
            instance = new EmployeeSingleton();
        }
        return instance;
    }

    private EmployeeSingleton(){
    }

    private String name;
    private double hourlyRate;
    private boolean isManager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }
}
