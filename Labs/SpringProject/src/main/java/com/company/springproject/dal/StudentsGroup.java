package com.company.springproject.dal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "StudentsGroups")
public class StudentsGroup {
    public Integer Id;
    public Integer StudentId;
    public Integer GroupId;
}
