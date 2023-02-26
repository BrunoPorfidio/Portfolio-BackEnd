package com.api.apiportfolio.service;

import com.api.apiportfolio.model.Persona;
import com.api.apiportfolio.repository.PersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public void buscarPorId(Long id) {
        personaRepo.findById(id).get();
    }

}
