package com.api.apiportfolio.controller;

import com.api.apiportfolio.service.IExperienciaService;
import com.api.apiportfolio.model.Experiencia;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "*")
public class ExperienciaController {
    
    @Autowired
    IExperienciaService iexperienciaService;
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Experiencia> verExperiencia() {
        return iexperienciaService.verExperiencia();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public void crearExperiencia(@RequestBody Experiencia experiencia) {
        iexperienciaService.crearExperiencia(experiencia);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void borrarExperiencia (@PathVariable Long id) {
        iexperienciaService.eliminarExperiencia(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("editar/{id}")
    public Experiencia editarExperiencia(@PathVariable("id") Long id,
                                      @RequestBody Experiencia experiencia) {
        experiencia.setIdExperiencia(id);
        
        iexperienciaService.crearExperiencia(experiencia);
        return experiencia;
    }

    @GetMapping(path = {"/{id}"})
    public Experiencia listarId(@PathVariable("id") Long id) {
        return iexperienciaService.buscarExperiencia(id);
    }
    
}
