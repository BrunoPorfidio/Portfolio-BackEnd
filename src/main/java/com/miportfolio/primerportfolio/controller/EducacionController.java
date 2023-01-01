package com.miportfolio.primerportfolio.controller;

import com.miportfolio.primerportfolio.model.Educacion;
import com.miportfolio.primerportfolio.model.Usuario;
import com.miportfolio.primerportfolio.repository.UsuarioRepository;
import com.miportfolio.primerportfolio.repository.EducacionRepository;
import com.miportfolio.primerportfolio.service.EducacionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/edit_educacion")
public class EducacionController {

    
    

    @Autowired
    EducacionServiceImp educacionServiceImp;
    UsuarioRepository usuarioRepository;
    

    @GetMapping("/estudio")
    public List<Educacion> getEducacion(){
        return educacionServiceImp.getEducacion();
    }

    @PostMapping("/crear_estudio/{id}")
    public String createEducacion(@RequestBody Educacion edu, @PathVariable Integer id){

        Usuario usr = usuarioRepository.getById(id);

        // Cargamos la experiencia al usuario que elijamos
        usr.getEducacion().add(edu);

        educacionServiceImp.saveEducacion(edu);

        return "Estudio creado";
    }

    @DeleteMapping("/eliminar_estudio/{id}")
    public String deleteEducacion(@PathVariable Integer id){

        educacionServiceImp.deleteEducacion(id);

        return "Estudio eliminado";
    }

    // Creamos un metodo para editar una persona dentro de la base de datos, filtramos por su id
    @PutMapping("/editar_estudio")
    public Educacion editarEducacion (
            @RequestBody Educacion educacion
    ){

        // Guardamos las modificaciones
        educacionServiceImp.saveEducacion(educacion);

        return educacion;
    }
}