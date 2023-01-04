package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Experiencia;
import com.apiportfolio.apiportfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {
    
    @Autowired
    private ExperienciaRepository experienciarepository;
    
    public List<Experiencia> verExperiencia(){
        return experienciarepository.findAll();
    }
    
    public void crearExperiencia(Experiencia experiencia){
    experienciarepository.save(experiencia);
    }
    
    public Experiencia obtenerExperiencia(Integer id){
        return experienciarepository.findById(id).get();
    }
    
    public void eliminarExperiencia(Integer id){
        experienciarepository.deleteById(id);
    }
    
}
