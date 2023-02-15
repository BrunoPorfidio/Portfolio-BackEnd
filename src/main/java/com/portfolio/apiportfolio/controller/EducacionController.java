package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Educacion;
import com.portfolio.apiportfolio.model.Persona;
import com.portfolio.apiportfolio.repository.EducacionRepo;
import com.portfolio.apiportfolio.repository.PersonaRepo;
import com.portfolio.apiportfolio.service.IEducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://miportfolioweb-e312a.web.app/")
public class EducacionController {

    @Autowired
    private IEducacionService educacionService;

    @Autowired
    private PersonaRepo personaRepo;
    
    @Autowired
    private EducacionRepo educacionRepo;

    @GetMapping("/ver")
    @ResponseBody
    public List<Educacion> verEducacion() {
        return educacionService.verEducacion();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Educacion> obtenerEducacionPorId(@PathVariable Long id) {
        Educacion educacion = educacionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro Educacion con el ID" + id));

        return ResponseEntity.ok(educacion);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo/{id}")
    public void agregarEducacion(@RequestBody Educacion educacion, @PathVariable Long id ) {
        
        Persona pers = personaRepo.getById(id);
        pers.getEducacion().add(educacion);
        educacionService.crearEducacion(educacion);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void eliminarEducacion(@PathVariable Long id) {
        educacionService.eliminarEducacion(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public Educacion editarEducacion(@RequestBody Educacion educacion){
        educacionService.crearEducacion(educacion);
        return educacion;
    }
}
