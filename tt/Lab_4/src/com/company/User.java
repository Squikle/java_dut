package com.company;

public class User {
    public String name;
    public int age;
    public int height;
    public String group;
    public String password;
    public String email;

    public User(){

    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User(String name, int age, int height, String group, String password, String email) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.group = group;
        this.password = password;
        this.email = email;
    }
}
