package com.corpfield.StudentRegistration.dao.dto;

import lombok.Data;

@Data
public class CreateProfessorReqDto {
    private long professorId;
    private String professorName;
    private String professorAge;
    private String professorMail;
    private String professorNumber;
}
