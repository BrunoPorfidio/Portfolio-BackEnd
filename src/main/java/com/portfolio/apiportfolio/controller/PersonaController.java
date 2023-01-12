package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Persona;
import com.portfolio.apiportfolio.repository.PersonaRepo;
import com.portfolio.apiportfolio.service.IPersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("ver/perfil/{id}")
    public Persona mostrarPersona(Long id) {
        return personaService.buscarPersona(id);
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
    public ResponseEntity<Persona> editarPersona(@PathVariable("id") Long id, @RequestBody Persona persona) {
        Optional<Persona> PersonaData = personaRepo.findById(id);

        if (PersonaData.isPresent()) {
            Persona _persona = PersonaData.get();
            _persona.setNombre(persona.getNombre());
            _persona.setApellido(persona.getApellido());
            _persona.setSubTitulo(persona.getSubTitulo());
            _persona.setAcercaMi(persona.getAcercaMi());
            _persona.setUrlFoto(persona.getUrlFoto());
            _persona.setLinkedinUrl(persona.getLinkedinUrl());
            _persona.setGithubUrl(persona.getGithubUrl());
            _persona.setImgBanner(persona.getImgBanner());

            return new ResponseEntity<>(personaRepo.save(_persona), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}