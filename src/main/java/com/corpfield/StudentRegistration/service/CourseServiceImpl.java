package com.corpfield.StudentRegistration.service;

import com.corpfield.StudentRegistration.constants.ResponseCodes;
import com.corpfield.StudentRegistration.dao.CourseDao;
import com.corpfield.StudentRegistration.dto.CreateCourseReqDto;
import com.corpfield.StudentRegistration.dto.ListCourseResDto;
import com.corpfield.StudentRegistration.dto.responseDto.ResponseDto;
import com.corpfield.StudentRegistration.entity.Course;
import com.corpfield.StudentRegistration.entity.Professor;
import com.corpfield.StudentRegistration.repo.CourseRepo;
import com.corpfield.StudentRegistration.repo.ProfessorRepo;
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
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo myCourseRepo;

    @Autowired
    ProfessorRepo myProfessorRepo;

    @Autowired
    CourseDao myCourseDao;

    @Override
    public void createCourseDetails(CreateCourseReqDto reqDto) {
        try {
            Course course = new Course();
            course.setCourseName(reqDto.getCourseName());
            Optional<Professor> profOptional = myProfessorRepo.findById(reqDto.getProfessorId());
            if (profOptional.isPresent()) {
                Professor professor = profOptional.get();
                course.setProfessor(professor);
            }
            myCourseRepo.save(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public ResponseDto getPagedCourseList(Pageable pageable) {
        try {
            List<Object[]> query = myCourseDao.getCourseWith(pageable);
            int totalCourse = myCourseDao.getTotalCourse();
            List<ListCourseResDto> course = getCourseList(query);
            Page<ListCourseResDto> pagedCourse = new PageImpl<>(course, pageable, totalCourse);
            return new ResponseDto(pagedCourse,ResponseCodes.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto("Oops! Error in server we are looking into it",ResponseCodes.SERVER_ERROR);
        }
    }
    private List<ListCourseResDto>getCourseList(List<Object[]>query){
        List<ListCourseResDto> obj = new ArrayList<>();
        for(Object[] row : query){
            ListCourseResDto dto = new ListCourseResDto();
            dto.setCourseName(ConvertObjToString(row[0]));
            dto.setProfessorName(ConvertObjToString(row[1]));
            obj.add(dto);
        }
        return obj;
    }

    @Override
    public ResponseDto getCourseByProfessorId(Pageable pageable, long professorId) {
        try {
            if(professorId<1){
                return new ResponseDto("Invalid professor id",ResponseCodes.INVALID_INPUT);
            }
            List<Object[]> query = myCourseDao.getCourseWithProfessorId(pageable,professorId);
            int totalCourseById = myCourseDao.getTotalCourseById(professorId);
            List<ListCourseResDto> course = getCourseById(query);
            Page<ListCourseResDto> pagedCourse = new PageImpl<>(course, pageable, totalCourseById);
            return new ResponseDto(pagedCourse,ResponseCodes.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto("Oops! Error in server we are looking into it",ResponseCodes.SERVER_ERROR);
        }
    }
    private List<ListCourseResDto>getCourseById(List<Object[]>query){
        List<ListCourseResDto> obj = new ArrayList<>();
        for(Object[] row : query){
            ListCourseResDto dto = new ListCourseResDto();
            dto.setCourseName(ConvertObjToString(row[0]));
            dto.setProfessorName(ConvertObjToString(row[1]));
            obj.add(dto);
        }
        return obj;
    }
}


