package com.company.modules;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String dishName;
    public double price;
    public String weight;
    public boolean isDiscount;
}
