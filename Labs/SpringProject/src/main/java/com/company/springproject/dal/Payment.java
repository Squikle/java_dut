package com.company.springproject.dal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Payments")
public class Payment {
    public Integer Id;
    public Integer StudentId;
    public Integer SchoolId;
    public Float Amount;
}
