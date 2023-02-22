package com.portfolio.api.controller;

import com.portfolio.api.model.Educacion;
import com.portfolio.api.model.Persona;
import com.portfolio.api.repository.EducacionRepo;
import com.portfolio.api.repository.PersonaRepo;
import com.portfolio.api.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "*")
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

    @PostMapping("/nuevo/{id}")
    public void agregarEducacion(@RequestBody Educacion educacion, @PathVariable Long id ) {
        
        Persona pers = personaRepo.getById(id);
        pers.getEducacion().add(educacion);
        educacionService.crearEducacion(educacion);
    }

    @DeleteMapping("/borrar/{id}")
    public void eliminarEducacion(@PathVariable Long id) {
        educacionService.eliminarEducacion(id);
    }

    @PutMapping("/editar")
    public Educacion editarEducacion(@RequestBody Educacion educacion){
        educacionService.crearEducacion(educacion);
        return educacion;
    }
}