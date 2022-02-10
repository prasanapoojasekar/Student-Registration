package com.corpfield.StudentRegistration.Controller;
import com.corpfield.StudentRegistration.Dto.ListStudentResDto;
import com.corpfield.StudentRegistration.Dto.StudentCreateDto;
import com.corpfield.StudentRegistration.Service.StudentService;
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
public class StudentController {
    @Autowired
    StudentService myStudentService;
    @PostMapping("/createStudent")
    public ResponseEntity<String>createStudent(@RequestBody StudentCreateDto reqDto){
        myStudentService.createStudent(reqDto);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
    @GetMapping("/getPagedStudentsList")
    public ResponseEntity<Page<ListStudentResDto>>getPagedStudentsList(
        @PageableDefault(size = 5) Pageable pageable

        ){
        Page<ListStudentResDto> users = myStudentService.getPagedStudentsList(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
}
}
