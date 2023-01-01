package com.miportfolio.primerportfolio.controller;


import com.miportfolio.primerportfolio.model.Experiencia;
import com.miportfolio.primerportfolio.model.Usuario;
import com.miportfolio.primerportfolio.repository.UsuarioRepository;
import com.miportfolio.primerportfolio.service.ExperienciaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edit_mode")
@CrossOrigin(origins = "*")
public class ExperienciaController {

    @Autowired
    ExperienciaServiceImp experienciaServiceImp;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/experiencia")
    public List<Experiencia> getExperiencia(){
        return experienciaServiceImp.getExperiencia();
    }

    @PostMapping("/crear_experiencia/{id}")
    public String createExperiencia(@RequestBody Experiencia exp, @PathVariable Integer id){

        Usuario usr = usuarioRepository.getById(id);

        usr.getExperiencia().add(exp);

        experienciaServiceImp.saveExperiencia(exp);

        return "Experiencia creada";
    }

    @DeleteMapping("/eliminar_experiencia/{id}")
    public String deleteExperiencia(@PathVariable Integer id){

        experienciaServiceImp.deleteExperiencia(id);

        return "Experiencia eliminada";
    }

    // Creamos un metodo para editar una persona dentro de la base de datos, filtramos por su id
    @PutMapping("/editar_experiencia")
    public String editarExperiencia (
            @RequestBody Experiencia experiencia
    ){

        experienciaServiceImp.saveExperiencia(experiencia);

        return "Experiencia editada";
    }
}
