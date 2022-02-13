package com.corpfield.StudentRegistration.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class StudentCourseDaoImpl implements StudentCourseDao{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Object[]>getStudentCourseWith(Pageable pageable){
        String myQuery = "select " +
       "student_course.student_course_name, " +
                "students.student_name " +
         "from student_course " +
       "inner join students on students.student_id =student_course.student_course_id";
        Query query=em.createNativeQuery(myQuery);
        query.setFirstResult(pageable.getPageNumber()*pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();
    }

    @Override
    public int getTotalStudentCourse(){
        String myQuery = "select " +
                "count(*) " +
                "from student_course " +
                "inner join students on students.student_id =student_course.student_course_id";
        Query query=em.createNativeQuery(myQuery);
        String result = String.valueOf (query.getSingleResult());
        return Integer.parseInt(result);


    }
}

