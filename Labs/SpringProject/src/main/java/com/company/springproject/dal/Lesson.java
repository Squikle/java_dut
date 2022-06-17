package com.company.springproject.dal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Lessons")
public class Lesson {
    public Integer Id;
    public Integer InstructorId;
    public Integer TopicId;
}