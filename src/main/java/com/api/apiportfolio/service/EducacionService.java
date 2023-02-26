package com.api.apiportfolio.service;

import com.api.apiportfolio.model.Educacion;
import com.api.apiportfolio.repository.EducacionRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService implements IEducacionService {

    @Autowired
    public EducacionRepo educacionRepo;

    @Override
    public List<Educacion> verEducacion() {
        List<Educacion> educacion = educacionRepo.findAll();
        return educacion;
    }

    @Override
    public void crearEducacion(Educacion educacion) {
        educacionRepo.save(educacion);
    }

    @Override
    public void eliminarEducacion(Long id) {
        educacionRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        Educacion educacion = educacionRepo.findById(id).orElse(null);
        return educacion;
    }

}
