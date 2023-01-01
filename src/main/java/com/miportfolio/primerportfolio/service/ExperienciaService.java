package com.miportfolio.primerportfolio.service;

import com.miportfolio.primerportfolio.model.Experiencia;
import com.miportfolio.primerportfolio.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService implements ExperienciaServiceImp{

    @Autowired
    ExperienciaRepository experienciaRepository;

    @Override
    public List<Experiencia> getExperiencia() {
        return experienciaRepository.findAll();
    }

    @Override
    public void saveExperiencia(Experiencia exp) {
        experienciaRepository.save(exp);
    }

    @Override
    public void deleteExperiencia(Integer id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Integer id) {
        return experienciaRepository.findById(id).orElse(null);
    }
}