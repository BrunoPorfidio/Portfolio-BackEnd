package com.miportfolio.primerportfolio.service;

import com.miportfolio.primerportfolio.model.Educacion;
import com.miportfolio.primerportfolio.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacionService implements EducacionServiceImp{

    @Autowired
    EducacionRepository educacionRepository;

    @Override
    public List<Educacion> getEducacion() {
        return educacionRepository.findAll();
    }

    @Override
    public void saveEducacion(Educacion edu) {
        educacionRepository.save(edu);
    }

    @Override
    public void deleteEducacion(Integer id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Integer id) {
        return educacionRepository.findById(id).orElse(null);
    }
}
