package com.corpfield.StudentRegistration.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name ="student_course")
@Entity
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="studentCourse_id")
    private long studentCourseId;

    @Column(name ="studentCourse_name")
    private  String StudentCourseName;

    @ManyToOne
    @JoinColumn(name ="student_id")
    private Student student;
}
