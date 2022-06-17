package com.company.springproject.dal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Groups")
public class Group {
    public Integer Id;
    public Integer InstructorId;
    public Integer SchoolId;
}
