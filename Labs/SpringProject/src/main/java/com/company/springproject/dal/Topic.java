package com.company.springproject.dal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Topics")
public class Topic {
    public Integer Id;
    public String Name;
    public String Description;
}