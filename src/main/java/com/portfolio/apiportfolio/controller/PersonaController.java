package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Persona;
import com.portfolio.apiportfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

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
    public void agregarPersona(@RequestBody Persona persona
    ) {
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
    public Persona editarPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("acercaMi") String nuevoAcercaMi,
            @RequestParam("urlFoto") String nuevoUrlFoto,
            @RequestParam("likedinUrl") String nuevaLikedinUrl,
            @RequestParam("githubUrl") String nuevaGithubUrl,
            @RequestParam("imgBanner") String nuevaImgBanner
    ) {
        Persona persona = personaService.buscarPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setTitulo(nuevoTitulo);
        persona.setAcercaMi(nuevoAcercaMi);
        persona.setUrlFoto(nuevoUrlFoto);
        persona.setLikedinUrl(nuevaLikedinUrl);
        persona.setGithubUrl(nuevaGithubUrl);
        persona.setImgBanner(nuevaImgBanner);

        personaService.crearPersona(persona);
        return persona;
    }
}
