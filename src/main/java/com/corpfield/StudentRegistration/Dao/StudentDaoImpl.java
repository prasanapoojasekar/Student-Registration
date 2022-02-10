package com.corpfield.StudentRegistration.Dao;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Component
public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    EntityManager em;
    @Override
    public List<Object[]> getStudentWith(Pageable pageable){
        String myQuery = "select "+
                "students.student_name, "+
                "students.student_age, "+
                "students.student_email, "+
                "students.student_phone_number "+
                "from students";
        Query query=em.createNativeQuery(myQuery);
        query.setFirstResult(pageable.getPageNumber()*pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();
    }
    @Override
    public int getTotalStudents(){
        String myQuery = "select "+
                "count(*) "+
                "from students";
        Query query=em.createNativeQuery(myQuery);
        String result = String.valueOf (query.getSingleResult());
        return Integer.parseInt(result);
    }
}
