package com.corpfield.StudentRegistration.Service;
import com.corpfield.StudentRegistration.Dto.ListStudentResDto;
import com.corpfield.StudentRegistration.Dto.StudentCreateDto;
import com.corpfield.StudentRegistration.Entity.Student;
import com.corpfield.StudentRegistration.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.corpfield.StudentRegistration.Dao.StudentDao;
import java.util.ArrayList;
import java.util.List;

import static com.corpfield.StudentRegistration.Utils.QueryUtils.ConvertObjToString;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    StudentDao studentDao;

    @Override
    public void createStudent(StudentCreateDto reqDto) {
        try {
            Student student = new Student();
            student.setStudentName(reqDto.getStudentName());
            student.setStudentAge(reqDto.getStudentAge());
            student.setStudentEmail(reqDto.getStudentEmail());
            student.setStudentPhoneNumber(reqDto.getStudentPhoneNumber());
            studentRepo.save(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Page<ListStudentResDto>getPagedStudentsList(Pageable pageable){
        try{
            List<Object[]> query = studentDao.getStudentWith(pageable);
            int totalStudents = studentDao.getTotalStudents();
            List<ListStudentResDto> students = getStudentList(query);
            Page<ListStudentResDto> pagedStudents = new PageImpl<>(students, pageable, totalStudents);
            return pagedStudents;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    private List<ListStudentResDto> getStudentList(List<Object[]> query) {
        List<ListStudentResDto> obj = new ArrayList<>();
        for(Object[] row : query){
            ListStudentResDto dto  = new ListStudentResDto();
            dto.setStudentName(ConvertObjToString(row[0]));
            dto.setStudentAge(ConvertObjToString(row[1]));
            dto.setStudentEmail(ConvertObjToString(row[2]));
             dto.setStudentPhoneNumber(ConvertObjToString(row[3]));
             obj.add(dto);

        }
        return obj;
    }
}