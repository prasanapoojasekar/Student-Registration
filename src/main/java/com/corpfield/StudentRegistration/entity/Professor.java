package com.corpfield.StudentRegistration.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity(name = "professors")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Professor_id")
    private long professorId;

    @Column(name = "Professor_name")
    private String professorName;

    @Column(name = "Professor_age")
    private String professorAge;

    @Column(name = "Professor_mail")
    private String professorMail;

    @Column(name = "professor_Number")
    private String professorNumber;
}
