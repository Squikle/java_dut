package com.company.springproject.dal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "PracticeLessons")
public class PracticeLesson {
    public Integer Id;
    public Integer LessonId;
    public Integer StudentId;
    public Integer CarId;
}
