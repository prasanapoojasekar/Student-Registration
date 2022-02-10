package com.corpfield.StudentRegistration.dto;

import lombok.Data;

@Data
public class CreateCourseReqDto {

    private long professorId;
    private String courseName;
}
