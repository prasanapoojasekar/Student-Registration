package com.corpfield.StudentRegistration.dto;

import lombok.Data;

@Data
public class CreateStudentCourseReqDto {

    private long studentId;
    private String studentCourseName;
}
