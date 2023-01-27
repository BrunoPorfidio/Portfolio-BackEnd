package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Experiencia;
import com.portfolio.apiportfolio.model.Persona;
import com.portfolio.apiportfolio.repository.ExperienciaRepo;
import com.portfolio.apiportfolio.repository.PersonaRepo;
import com.portfolio.apiportfolio.service.IExperienciaService;
import java.util.List;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = {"http://localhost:4200", "https://miportfolioweb-e312a.web.app"})
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
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Experiencia> obtenerExperienciaPorId(@PathVariable Long id) {
        Experiencia experiencia = experienciaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro Experienia con el ID" + id));

        return ResponseEntity.ok(experiencia);
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
