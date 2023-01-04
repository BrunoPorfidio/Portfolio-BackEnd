package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Educacion;
import com.apiportfolio.apiportfolio.repository.EducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService implements IEducacionService{
    
    @Autowired
    private EducacionRepository educacionrepository;
   
    @Override
    public List<Educacion> verEducacion() {
        return educacionrepository.findAll();
    }

    @Override
    public void crearEducacion(Educacion educacion) {
        educacionrepository.save(educacion);
    }

    @Override
    public void eliminarEducacion(Integer id) {
                educacionrepository.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Integer id) {
        return educacionrepository.findById(id).get();
    }
    
}
