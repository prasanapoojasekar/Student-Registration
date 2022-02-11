package com.corpfield.StudentRegistration.Service;

import com.corpfield.StudentRegistration.Dao.ProfessorDao;
import com.corpfield.StudentRegistration.Dto.CreateProfessorReqDto;
import com.corpfield.StudentRegistration.Dto.ListProfessorResDto;
import com.corpfield.StudentRegistration.Entity.Professor;
import com.corpfield.StudentRegistration.Repo.ProfessorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.corpfield.StudentRegistration.Utils.QueryUtils.ConvertObjToString;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorRepo myProfessorRepo;

    @Autowired
    ProfessorDao myProfessorDao;

    @Override
    public void createProfessorDetails(CreateProfessorReqDto requestDto) {
        try {
            Professor prof = new Professor();
            prof.setProfessorName(requestDto.getProfessorName());
            prof.setProfessorAge(requestDto.getProfessorAge());
            prof.setProfessorMail(requestDto.getProfessorMail());
            prof.setProfessorNumber(requestDto.getProfessorNumber());
            myProfessorRepo.save(prof);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Page<ListProfessorResDto> getPagedProfessorsList(Pageable pageable) {
        try {
            List<Object[]> query = myProfessorDao.getProfessorWith(pageable);
            int totalProfessors = myProfessorDao.getTotalProfessors();
            List<ListProfessorResDto> professors = getProfessorList(query);
            Page<ListProfessorResDto> pagedProf = new PageImpl<>(professors, pageable, totalProfessors);
            return pagedProf;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private List<ListProfessorResDto>getProfessorList(List<Object[]>query){
        List<ListProfessorResDto> obj = new ArrayList<>();
        for(Object[] row : query){
            ListProfessorResDto dto = new ListProfessorResDto();
            dto.setProfessorName(ConvertObjToString(row[0]));
            dto.setProfessorAge(ConvertObjToString(row[1]));
            dto.setProfessorMail(ConvertObjToString(row[2]));
            dto.setProfessorNumber(ConvertObjToString(row[3]));
            obj.add(dto);
        }
        return obj;
    }
}
