package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Skills;
import com.apiportfolio.apiportfolio.repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService {
    
    @Autowired
    private SkillsRepository skillsrepository;
    
    public List<Skills> verSkills(){
        return skillsrepository.findAll();
    }
    
    public void crearSkills(Skills skills){
        skillsrepository.save(skills);
    }
    
    public Skills obtenerSkills(Integer id){
        return skillsrepository.findById(id).get();
    }
    
    public void eliminarSkills(Integer id){
        skillsrepository.deleteById(id);
    }
    
    
}
