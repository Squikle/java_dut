package com.company.springproject.dal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Students")
public class Student {
    public Integer Id;
    public Integer PersonId;
    public Integer SchoolId;
}
