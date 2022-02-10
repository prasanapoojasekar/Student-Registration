package com.corpfield.StudentRegistration.controller;

import com.corpfield.StudentRegistration.dto.CreateCourseReqDto;
import com.corpfield.StudentRegistration.dto.ListCourseResDto;
import com.corpfield.StudentRegistration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseService myCourseService;

    @PostMapping("/course")
    public ResponseEntity<String>createCourseDetails(@RequestBody CreateCourseReqDto reqDto){
        myCourseService.createCourseDetails(reqDto);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/course")
    public ResponseEntity<Page<ListCourseResDto>> getPagedCourseList(
            @PageableDefault(size = 5) Pageable pageable
    ){
        Page<ListCourseResDto> course = myCourseService.getPagedCourseList(pageable);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

}
