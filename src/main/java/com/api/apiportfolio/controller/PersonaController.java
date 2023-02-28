package com.api.apiportfolio.controller;

import com.api.apiportfolio.service.IPersonaService;
import com.api.apiportfolio.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaController {
    
    @Autowired
    IPersonaService ipersonaService;
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Persona> verPersona() {
        return ipersonaService.verPersonas();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public void crearPersona(@RequestBody Persona persona) {
        ipersonaService.crearPersona(persona);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void borrarPersona(@PathVariable Long id) {
        ipersonaService.eliminarPersona(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Persona editarPersona(@PathVariable("id") Long id,
                                      @RequestBody Persona persona) {
        persona.getId();
        
        ipersonaService.crearPersona(persona);
        return persona;
    }

    @GetMapping(path = {"/{id}"})
    public Persona listarId(@PathVariable("id") Long id) {
        return ipersonaService.buscarPersona(id);
    }
}
