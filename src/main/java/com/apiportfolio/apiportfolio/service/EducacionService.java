package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Educacion;
import com.apiportfolio.apiportfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService {
    
    @Autowired
    private EducacionRepository educacionrepository;
    
    public List<Educacion> verEducacion(){
        return educacionrepository.findAll();
    }
    
    public void crearEducacion(Educacion educacion){
        educacionrepository.save(educacion);
    }
    
    public Educacion obtenerEducacion(Integer id){
        return educacionrepository.findById(id).get();
    }
    
    public void eliminarEducacion(Integer id){
        educacionrepository.deleteById(id);
    }
    
}
