package com.miportfolio.primerportfolio.service;

import com.miportfolio.primerportfolio.model.Skills;
import com.miportfolio.primerportfolio.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillsServiceImp {
    
    List<Skills> getSkills();

    // Guardar una persona
    void saveSkills (Skills habilidad);

    // Eliminar una persona
    void deleteSkills (Integer id);

    // Encontrar una persona por id
    Skills findSkills (Integer id);
}
