package com.miportfolio.primerportfolio.service;

import com.miportfolio.primerportfolio.model.Skills;
import com.miportfolio.primerportfolio.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsService implements SkillsServiceImp{

    @Autowired
    SkillsRepository skillsRepository;

    @Override
    public List<Skills> getSkills() {
        return skillsRepository.findAll();
    }

    @Override
    public void saveSkills(Skills skll) {
        skillsRepository.save(skll);
    }

    @Override
    public void deleteSkills(Integer id) {
        skillsRepository.deleteById(id);
    }

    @Override
    public Skills findSkills(Integer id) {
        return skillsRepository.findById(id).orElse(null);
    }
}
