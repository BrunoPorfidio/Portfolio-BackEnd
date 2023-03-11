package com.api.apiportfolio.controller;

import com.api.apiportfolio.service.IEducacionService;
import com.api.apiportfolio.model.Educacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "*")
public class EducacionController {

    @Autowired
    IEducacionService ieducacionService;

    @GetMapping("/ver")
    @ResponseBody
    public List<Educacion> verEducacion() {
        return ieducacionService.verEducacion();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public void crearEstudio(@RequestBody Educacion educacion) {
        ieducacionService.crearEducacion(educacion);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void borrarEstudio(@PathVariable Long id) {
        ieducacionService.eliminarEducacion(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("editar/{id}")
    public Educacion editarEducaciono(@PathVariable("id") Long id,
                                      @RequestBody Educacion educacion) {
        educacion.setidEducacion(id);
        
        ieducacionService.crearEducacion(educacion);
        return educacion;
    }

    @GetMapping(path = {"/{id}"})
    public Educacion listarId(@PathVariable("id") Long id) {
        return ieducacionService.buscarEducacion(id);
    }
}
