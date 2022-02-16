package com.corpfield.StudentRegistration.controller;

import com.corpfield.StudentRegistration.constants.CommonConstants;
import com.corpfield.StudentRegistration.dto.ListStudentResDto;
import com.corpfield.StudentRegistration.dto.StudentCreateReqDto;
import com.corpfield.StudentRegistration.dto.responseDto.ResponseDto;
import com.corpfield.StudentRegistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService myStudentService;

    @PostMapping("/student")
    public ResponseEntity<String> createStudent(@RequestBody StudentCreateReqDto reqDto) {
        myStudentService.createStudent(reqDto);
        return new ResponseEntity<>("studentCourse details created successfully", HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseDto> getPagedStudentsList(
            @PageableDefault(size = CommonConstants.DEFAULT_PAGE_SIZE) Pageable pageable

    ) {
         ResponseDto users = (ResponseDto) myStudentService.getPagedStudentsList(pageable);
        return new ResponseEntity<>(users,  HttpStatus.valueOf(users.getStatus()));
    }

}

