package com.corpfield.StudentRegistration.service;

import com.corpfield.StudentRegistration.constants.ResponseCodes;
import com.corpfield.StudentRegistration.dao.StudentCourseDao;
import com.corpfield.StudentRegistration.dto.CreateStudentCourseReqDto;
import com.corpfield.StudentRegistration.dto.ListStudentCourseResDto;
import com.corpfield.StudentRegistration.dto.responseDto.ResponseDto;
import com.corpfield.StudentRegistration.entity.Student;
import com.corpfield.StudentRegistration.entity.StudentCourse;
import com.corpfield.StudentRegistration.exceptions.ServiceException;
import com.corpfield.StudentRegistration.repo.StudentCourseRepo;
import com.corpfield.StudentRegistration.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.corpfield.StudentRegistration.utils.QueryUtils.ConvertObjToString;
@Service
public class StudentCourseServiceImpl implements  StudentCourseService {
    @Autowired
    StudentCourseRepo myStudentCourseRepo;

    @Autowired
    StudentRepo myStudentRepo;

    @Autowired
    StudentCourseDao myStudentCourseDao;

    @Override
    public void createStudentCourse(CreateStudentCourseReqDto reqDto) {
        try {
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setStudentCourseName(reqDto.getStudentCourseName());
            Optional<Student> studentOptional = myStudentRepo.findById(reqDto.getStudentId());
            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                studentCourse.setStudent(student);
            }
            myStudentCourseRepo.save(studentCourse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResponseDto getPagedStudentCourseList(Pageable pageable) {
        try {
            List<Object[]> query = myStudentCourseDao.getStudentCourseWith(pageable);
            int totalStudentCourse = myStudentCourseDao.getTotalStudentCourse();
            List<ListStudentCourseResDto> studentCourse = getStudentCourseList(query);
            Page<ListStudentCourseResDto> pagedStudentCourse = new PageImpl<>(studentCourse, pageable, totalStudentCourse);
            return new ResponseDto( pagedStudentCourse, ResponseCodes.SUCCESS);
        } catch (Exception e) {
            return ServiceException.sendErrorResponse(e);
        }
    }

    private List<ListStudentCourseResDto> getStudentCourseList(List<Object[]> query) {
        List<ListStudentCourseResDto> obj = new ArrayList<>();
        for (Object[] row : query) {
            ListStudentCourseResDto dto = new ListStudentCourseResDto();
            dto.setStudentCourseName(ConvertObjToString(row[0]));
            dto.setStudentName(ConvertObjToString(row[1]));
            obj.add(dto);
        }
        return obj;
    }
    @Override
    public ResponseDto getStudentCourseByStudentId(Pageable pageable, long studentId){
        try{
            if(studentId<1){
                throw new ServiceException("Please enter a valid user id");
            }
            List<Object[]>query = myStudentCourseDao.getStudentCourseWithStudentId(pageable, studentId);
            int totalStudentCourseById = myStudentCourseDao.getTotalStudentCourseById(studentId);
            List<ListStudentCourseResDto> studentCourse = getStudentCourseById(query);
            Page<ListStudentCourseResDto>pagedStudentCourse = new PageImpl<>(studentCourse, pageable, totalStudentCourseById);
            return new ResponseDto(pagedStudentCourse,ResponseCodes.SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            return ServiceException.sendErrorResponse(e);

        }
    }

    private List<ListStudentCourseResDto> getStudentCourseById(List<Object[]> query) {
        List<ListStudentCourseResDto>obj = new ArrayList<>();
        for(Object[] row : query ){
            ListStudentCourseResDto dto = new ListStudentCourseResDto();
            dto.setStudentCourseName(ConvertObjToString(row [0]));
            dto.setStudentName(ConvertObjToString(row [1]));
            obj.add(dto);
        }
        return obj;
    }
}



