package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Experiencia;
import com.apiportfolio.apiportfolio.repository.ExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    private ExperienciaRepository experienciarepository;

    @Override
    public List<Experiencia> verExperiencia() {
        return experienciarepository.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia experiencia) {
        experienciarepository.save(experiencia);
    }

    @Override
    public void eliminarExperiencia(Integer id) {
                experienciarepository.deleteById(id);

    }

    @Override
    public Experiencia buscarExperiencia(Integer id) {
        return experienciarepository.findById(id).get();
    }  
}
