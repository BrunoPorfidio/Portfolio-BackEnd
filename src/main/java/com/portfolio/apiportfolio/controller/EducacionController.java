package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Educacion;
import com.portfolio.apiportfolio.repository.EducacionRepo;
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
@CrossOrigin(origins = {"http://localhost:4200", "https://miportfolioweb-e312a.web.app"})
public class EducacionController {

    @Autowired
    private IEducacionService educacionService;

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
    @PostMapping("/nuevo")
    public void agregarEducacion(@RequestBody Educacion educacion) {
        educacionService.crearEducacion(educacion);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void eliminarEducacion(@PathVariable Long id) {
        educacionService.eliminarEducacion(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Educacion> editarSkill(@PathVariable Long id, @RequestBody Educacion eeducacion) {
        Educacion educacion = educacionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontreo la Persona con el ID" + id));
        educacion.setInstitucion(eeducacion.getInstitucion());
        educacion.setTitulo(eeducacion.getTitulo());
        educacion.setInicio(eeducacion.getInicio());
        educacion.setFin(eeducacion.getFin());
        educacion.setFotoEducacion(eeducacion.getFotoEducacion());

        Educacion guardarEducacion = educacionRepo.save(eeducacion);
        return ResponseEntity.ok(guardarEducacion);
    }

}
