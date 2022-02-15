package com.corpfield.StudentRegistration.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "professors")
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private long professorId;

    @Column(name = "professor_name")
    private String professorName;

    @Column(name = "professor_age")
    private String professorAge;

    @Column(name = "professor_mail")
    private String professorMail;

    @Column(name = "professor_number")
    private String professorNumber;
}
