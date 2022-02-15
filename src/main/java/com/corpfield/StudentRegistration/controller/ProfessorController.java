package com.corpfield.StudentRegistration.controller;

import com.corpfield.StudentRegistration.constants.CommonConstants;
import com.corpfield.StudentRegistration.dto.CreateProfessorReqDto;
import com.corpfield.StudentRegistration.dto.ListProfessorResDto;
import com.corpfield.StudentRegistration.dto.responseDto.ResponseDto;
import com.corpfield.StudentRegistration.service.ProfessorService;
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
public class ProfessorController {

    @Autowired
    ProfessorService myProfessorService;

    @PostMapping("/professors")
    public ResponseEntity<String> createProfessorDetails(@RequestBody CreateProfessorReqDto requestDto){
        myProfessorService.createProfessorDetails(requestDto);
        return new ResponseEntity<>("Professors details created successfully", HttpStatus.OK);
    }

    @GetMapping("/professors")
    public ResponseEntity<ResponseDto> getPagedProfessorsList(
            @PageableDefault(size = CommonConstants.DEFAULT_PAGE_SIZE) Pageable pageable
    ){
       ResponseDto users = myProfessorService.getPagedProfessorsList(pageable);
        return new ResponseEntity<>(users, HttpStatus.valueOf(users.getStatus()));
    }

}
