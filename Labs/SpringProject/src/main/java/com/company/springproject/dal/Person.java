package com.company.springproject.dal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Persons")
public class Person {
    public Integer Id;
    public String FistName;
    public String LastName;
    public String Phone;
    public String Email;
    public String Sex;
}
