package com.corpfield.StudentRegistration.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name= "course")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "course_id")
    private long courseId;

    @Column(name ="course_name")
    private String courseName;

    @ManyToOne
    @JoinColumn(name ="professor_id")
    private Professor professor;
}
