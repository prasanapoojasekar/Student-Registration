package com.corpfield.StudentRegistration.Dao;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class ProfessorDaoImpl implements ProfessorDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Object[]> getProfessorWith(Pageable pageable){
        String myQuery = "select " +
                "professors.professor_name, "+
                "professors.professor_age, "+
                "professors.professor_mail, "+
                "professors.professor_number "+
                "from professors";
        Query query=em.createNativeQuery(myQuery);
        query.setFirstResult(pageable.getPageNumber()*pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();
    }

    @Override
    public int getTotalProfessors(){
        String myQuery = "select " +
                "count(*) "+
                "from professors";
        Query query=em.createNativeQuery(myQuery);
        String result = String.valueOf (query.getSingleResult());
        return Integer.parseInt(result);
    }
}
