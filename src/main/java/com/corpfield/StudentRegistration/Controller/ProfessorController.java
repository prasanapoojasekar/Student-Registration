package com.corpfield.StudentRegistration.Controller;

import com.corpfield.StudentRegistration.Dto.CreateProfessorReqDto;
import com.corpfield.StudentRegistration.Dto.ListProfessorResDto;
import com.corpfield.StudentRegistration.Service.ProfessorService;
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

    @PostMapping("/createProfessorDetails")
    public ResponseEntity<String> createProfessorDetails(@RequestBody CreateProfessorReqDto requestDto){
        myProfessorService.createProfessorDetails(requestDto);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/getPagedProfessorsList")
    public ResponseEntity<Page<ListProfessorResDto>> getPagedProfessorsList(
            @PageableDefault(size = 5) Pageable pageable
    ){
        Page<ListProfessorResDto> users = myProfessorService.getPagedProfessorsList(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
