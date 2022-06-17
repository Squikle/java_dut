package com.company.springproject.dal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Instructors")
public class Instructor {
    public Integer Id;
    public Integer PersonId;
    public Integer SchoolId;
}
