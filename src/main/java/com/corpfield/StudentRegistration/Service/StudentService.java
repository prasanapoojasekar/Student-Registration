package com.corpfield.StudentRegistration.Service;


import com.corpfield.StudentRegistration.Dto.ListStudentResDto;
import com.corpfield.StudentRegistration.Dto.StudentCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    void createStudent(StudentCreateDto reqDto);


    Page<ListStudentResDto> getPagedStudentsList(Pageable pageable);

}
