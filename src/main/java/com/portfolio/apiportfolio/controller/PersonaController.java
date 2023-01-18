package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Persona;
import com.portfolio.apiportfolio.repository.PersonaRepo;
import com.portfolio.apiportfolio.service.IPersonaService;
import java.util.List;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = {"http://localhost:4200", "https://miportfolioweb-e312a.web.app"})
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    public PersonaRepo personaRepo;

    @GetMapping("/ver")
    @ResponseBody
    public List<Persona> verPersona() {
        return personaService.verPersonas();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        Persona persona = personaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontreo la Persona con el ID" + id));

        return ResponseEntity.ok(persona);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public void agregarPersona(@RequestBody Persona persona) {
        personaService.crearPersona(persona);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void eliminarPersona(@PathVariable Long id
    ) {
        personaService.eliminarPersona(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
        public ResponseEntity<Persona> editarPersona(@PathVariable Long id, @RequestBody Persona epersona){
           Persona persona = personaRepo.findById(id)
                   .orElseThrow(() -> new ResourceNotFoundException("No se encontreo la Persona con el ID" + id));
           persona.setNombre(epersona.getNombre());
           persona.setApellido(epersona.getApellido());
           persona.setSubTitulo(epersona.getSubTitulo());
           persona.setAcercaMi(epersona.getAcercaMi());
           persona.setUrlFoto(epersona.getUrlFoto());
           persona.setLinkedinUrl(epersona.getLinkedinUrl());
           persona.setGithubUrl(epersona.getGithubUrl());
           persona.setImgBanner(epersona.getImgBanner());
           
           Persona guardarPersona = personaRepo.save(epersona);
           return ResponseEntity.ok(guardarPersona);
    }
}
