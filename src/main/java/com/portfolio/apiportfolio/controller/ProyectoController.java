package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Persona;
import com.portfolio.apiportfolio.model.Proyectos;
import com.portfolio.apiportfolio.repository.PersonaRepo;
import com.portfolio.apiportfolio.repository.ProyectoRepo;
import com.portfolio.apiportfolio.service.IProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://miportfolioweb-e312a.web.app/")
public class ProyectoController {

    @Autowired
    private IProyectoService proyectoService;

    @Autowired
    private ProyectoRepo proyectoRepo;
    
    @Autowired
    private PersonaRepo personaRepo;
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Proyectos> verProyecto() {
        return proyectoService.verProyecto();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Proyectos> obtenerProyectoPorId(@PathVariable Long id) {
        Proyectos proyectos = proyectoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontreo Proyecto con el ID" + id));

        return ResponseEntity.ok(proyectos);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo/{id}")
    public void agregarProyecto(@RequestBody Proyectos proyectos, @PathVariable Long id ) {
        
        Persona pers = personaRepo.getById(id);
        pers.getProyectos().add(proyectos);
        proyectoService.crearProyecto(proyectos);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public Proyectos editarProyecto(@RequestBody Proyectos proyectos){
        proyectoService.crearProyecto(proyectos);
        return proyectos;
    }
}