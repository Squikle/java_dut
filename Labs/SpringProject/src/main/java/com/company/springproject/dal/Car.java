package com.company.springproject.dal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Cars")
public class Car {
    public Integer Id;
    public String Brand;
    public String Model;
    public String Number;
    public Integer Year;
    public String Color;
}
