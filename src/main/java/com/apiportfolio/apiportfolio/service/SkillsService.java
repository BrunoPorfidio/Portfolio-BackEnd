package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Skills;
import com.apiportfolio.apiportfolio.repository.SkillsRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillsService implements ISkillsService{
    
    @Autowired
    private SkillsRepository skillsrepository;
    
    @Override
    public List<Skills> verSkills(){
        return skillsrepository.findAll();
    }
    
    @Override
    public void crearSkills(Skills skills){
        skillsrepository.save(skills);
    }
    
    @Override
    public void eliminarSkills(Integer id){
        skillsrepository.deleteById(id);
    }

    @Override
    public Skills buscarSkills(Integer id) {
        return skillsrepository.findById(id).get();
    }
    
    
}
