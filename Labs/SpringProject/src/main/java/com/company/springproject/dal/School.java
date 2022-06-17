package com.company.springproject.dal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Schools")
public class School {
    public Integer Id;
    public String Address;
    public Float CoursePrice;
}
