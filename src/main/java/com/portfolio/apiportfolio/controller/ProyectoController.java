package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Proyectos;
import com.portfolio.apiportfolio.repository.ProyectoRepo;
import com.portfolio.apiportfolio.service.IProyectoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@CrossOrigin(origins = {"http://localhost:4200", "https://miportfolioweb-e312a.web.app"})
public class ProyectoController {

    @Autowired
    private IProyectoService proyectoService;

    @Autowired
    private ProyectoRepo proyectoRepo;

    @GetMapping("/ver")
    @ResponseBody
    public List<Proyectos> verProyecto() {
        return proyectoService.verProyecto();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public void agregarProyecto(@RequestBody Proyectos proyecto) {
        proyectoService.crearProyecto(proyecto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Proyectos> editarProyectos(@PathVariable("id") Long id, @RequestBody Proyectos proyectos) {
        Optional<Proyectos> ProyectosData = proyectoRepo.findById(id);

        if (ProyectosData.isPresent()) {
            Proyectos _proyectos = ProyectosData.get();
            _proyectos.setNombreProyecto(proyectos.getNombreProyecto());
            _proyectos.setDescripcion(proyectos.getDescripcion());
            _proyectos.setUrlProyecto(proyectos.getUrlProyecto());
            _proyectos.setFotoProyecto(proyectos.getFotoProyecto());

            return new ResponseEntity<>(proyectoRepo.save(_proyectos), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
