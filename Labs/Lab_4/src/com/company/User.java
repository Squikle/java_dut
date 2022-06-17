package com.company;

public class User {
    public String name;
    public int age;
    public int height;
    public String group;
    public String password;
    public String email;

    public User(int age, String name, String group, String password, int height, String email) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.group = group;
        this.password = password;
        this.email = email;
    }

    public User(String name, String email, int age) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
