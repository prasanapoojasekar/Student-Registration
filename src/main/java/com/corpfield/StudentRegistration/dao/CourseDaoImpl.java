package com.corpfield.StudentRegistration.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class CourseDaoImpl implements CourseDao{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Object[]> getCourseWith(Pageable pageable){
        String myQuery = "select " +
                "course.course_name, "+
                "professors.professor_name "+
                "from course "+
                "inner join professors on professors.professor_id= course.course_id";
        Query query=em.createNativeQuery(myQuery);
        query.setFirstResult(pageable.getPageNumber()*pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();
    }

    @Override
    public int getTotalCourse(){
        String myQuery = "select " +
                "count(*) "+
                "from course "+
                "inner join professors on professors.professor_id= course.course_id";
        Query query=em.createNativeQuery(myQuery);
        String result = String.valueOf (query.getSingleResult());
        return Integer.parseInt(result);
    }

    @Override
    public List<Object[]>getCourseWithProfessorId(Pageable pageable, long professorId){
        String myQuery = "select "+
                "course.course_name, "+
                "professors.professor_name "+
                "from course "+
                "inner join professors on professors.professor_id = course.professor_id "+
                "where professors.professor_id = :professorId ";
        Query query=em.createNativeQuery(myQuery);
        query.setParameter("professorId",professorId);
        query.setFirstResult(pageable.getPageNumber()*pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();
    }

    @Override
    public int getTotalCourseById(long professorId){
        String myQuery = "select " +
                "count(*) "+
                "from course "+
                "inner join professors on professors.professor_id= course.professor_id "+
                "where professors.professor_id = :professorId ";
        Query query=em.createNativeQuery(myQuery);
        query.setParameter("professorId",professorId);
        String result = String.valueOf (query.getSingleResult());
        return Integer.parseInt(result);
    }

}
