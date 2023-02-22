package com.portfolio.api.controller;

import com.portfolio.api.model.Persona;
import com.portfolio.api.repository.PersonaRepo;
import com.portfolio.api.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    public PersonaRepo personaRepo;

    @GetMapping("/ver")
    @ResponseBody
    public List<Persona> verPersona() {
        return personaService.verPersonas();
    }

    @GetMapping("/ver_uno/{id}")
    public Persona buscarPersona(@PathVariable Long id) {
        return personaService.buscarPersona(id);
    }

    @PostMapping("/nuevo")
    public void agregarPersona(@RequestBody Persona persona) {
        personaService.crearPersona(persona);
    }

    @DeleteMapping("/borrar/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
    }

    @PutMapping("/editar")
    public Persona editarPersona(@RequestBody Persona persona) {
        personaService.crearPersona(persona);

        return persona;
    }
}