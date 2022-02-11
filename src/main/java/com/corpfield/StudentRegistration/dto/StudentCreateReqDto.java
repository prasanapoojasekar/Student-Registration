package com.corpfield.StudentRegistration.dto;

import lombok.Data;

@Data
public class StudentCreateReqDto {
    private long studentId;
    private String studentName;
    private String studentAge;
    private String studentEmail;
    private String studentPhoneNumber;
}
