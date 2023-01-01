package com.miportfolio.primerportfolio.service;

import com.miportfolio.primerportfolio.model.Experiencia;
import com.miportfolio.primerportfolio.model.Usuario;

import java.util.List;

public interface ExperienciaServiceImp {


    List<Experiencia> getExperiencia();


    void saveExperiencia (Experiencia expr);


    void deleteExperiencia (Integer id);


    Experiencia findExperiencia (Integer id);
}