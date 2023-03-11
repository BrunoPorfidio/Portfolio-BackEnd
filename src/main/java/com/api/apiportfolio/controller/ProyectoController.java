package com.api.apiportfolio.controller;

import com.api.apiportfolio.service.IProyectoService;
import com.api.apiportfolio.model.Proyectos;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://miportfolioweb-e312a.web.app")
public class ProyectoController {
    
    @Autowired
    IProyectoService iproyectoService;
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Proyectos> verProyecto() {
        return iproyectoService.verProyecto();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public void crearProyecto(@RequestBody Proyectos proyectos) {
        iproyectoService.crearProyecto(proyectos);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        iproyectoService.eliminarProyecto(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("editar/{id}")
    public Proyectos editarProyecto(@PathVariable("id") Long id,
                                      @RequestBody Proyectos proyectos) {
        proyectos.getIdProyectos();
        
        iproyectoService.crearProyecto(proyectos);
        return proyectos;
    }

    @GetMapping(path = {"/{id}"})
    public Proyectos listarId(@PathVariable("id") Long id) {
        return iproyectoService.buscarProyecto(id);
    }
}
