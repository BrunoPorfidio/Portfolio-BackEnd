package com.portfolio.api.controller;

import com.portfolio.api.model.Experiencia;
import com.portfolio.api.model.Persona;
import com.portfolio.api.repository.ExperienciaRepo;
import com.portfolio.api.repository.PersonaRepo;
import com.portfolio.api.service.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "*")
public class ExperienciaController {

    @Autowired
    private IExperienciaService experienciaService;

    @Autowired
    private ExperienciaRepo experienciaRepo;
    
    @Autowired
    private PersonaRepo personaRepo;

    @GetMapping("/ver")
    @ResponseBody
    public List<Experiencia> verExperiencia() {
        return experienciaService.verExperiencia();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo/{id}")
    public void agregarExperiencia(@RequestBody Experiencia experiencia, @PathVariable Long id ) {
        
        Persona pers = personaRepo.getById(id);
        pers.getExperiencia().add(experiencia);
        experienciaService.crearExperiencia(experiencia);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void eliminarExperiencia(@PathVariable Long id) {
        experienciaService.eliminarExperiencia(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public Experiencia editarExperiencia(@RequestBody Experiencia experiencia){
        experienciaService.crearExperiencia(experiencia);
        return experiencia;
    }
}