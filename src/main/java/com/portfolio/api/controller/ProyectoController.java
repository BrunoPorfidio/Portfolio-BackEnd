package com.portfolio.api.controller;

import com.portfolio.api.model.Persona;
import com.portfolio.api.model.Proyectos;
import com.portfolio.api.repository.PersonaRepo;
import com.portfolio.api.repository.ProyectoRepo;
import com.portfolio.api.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin (origins="*")
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
