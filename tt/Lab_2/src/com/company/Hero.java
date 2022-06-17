package com.company;

import java.io.Serializable;

public class Hero implements Serializable {
    private final String name;
    private final String role;
    private final int intelligence;
    private final int agility;
    private final int strength;

    Hero(String name, String role, int intelligence, int agility, int strength){

        this.name = name;
        this.role = role;
        this.intelligence = intelligence;
        this.agility = agility;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public int getStrength() {
        return strength;
    }
}
