package com.portfolio.apiportfolio.service;

import com.portfolio.apiportfolio.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.apiportfolio.repository.PersonaRepo;
import javax.transaction.Transactional;

@Service
@Transactional
public class PersonaService implements IPersonaService {

    @Autowired
    public PersonaRepo personaRepo;

    @Override
    public List<Persona> verPersonas() {
        return personaRepo.findAll();
    }

    @Override
    public void crearPersona(Persona persona) {
        personaRepo.save(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return personaRepo.findById(id).orElse(null);
    }

    @Override
    public void getById(Long id) {
        personaRepo.findById(id).get();
    }

}
