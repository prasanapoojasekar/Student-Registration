package com.corpfield.StudentRegistration.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "students")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_age")
    private String studentAge;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "student_phone_number")
    private String studentPhoneNumber;
}
