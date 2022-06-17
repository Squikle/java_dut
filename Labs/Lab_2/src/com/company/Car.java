package com.company;

import java.io.Serializable;

public class Car implements Serializable {
    private final String brand;
    private final String model;
    private final int maxSpeed;
    private final int weight;

    Car(String brand, String model, int maxSpeed, int weight){

        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getWeight() {
        return weight;
    }
}
