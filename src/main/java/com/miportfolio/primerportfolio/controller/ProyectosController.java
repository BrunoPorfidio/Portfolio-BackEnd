package com.miportfolio.primerportfolio.controller;

import com.miportfolio.primerportfolio.model.Proyectos;
import com.miportfolio.primerportfolio.model.Usuario;
import com.miportfolio.primerportfolio.repository.UsuarioRepository;
import com.miportfolio.primerportfolio.service.ProyectosServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/edit_mode")
@CrossOrigin(origins = "*")
public class ProyectosController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProyectosServiceImp proyectosServiceImp;

    @GetMapping("/proyectos")
    public List<Proyectos> getProyectos(){
        return proyectosServiceImp.getProyectos();
    }

    @PostMapping("/crear_proyectos/{id}")
    public String createProyectos(@RequestBody Proyectos proyectos, @PathVariable Integer id){

        Usuario usr = usuarioRepository.getById(id);

        usr.getProyectos().add(proyectos);

        proyectosServiceImp.saveProyectos(proyectos);

        return "Proyecto creado";
    }

    @DeleteMapping("/eliminar_proyecto/{id}")
    public String deleteProyectos(@PathVariable Integer id){

        proyectosServiceImp.deleteProyectos(id);

        return "Proyecto eliminado";
    }

    @PutMapping("/editar_Proyecto")
    public Proyectos editProyectos(@RequestBody Proyectos proyectos){

        proyectosServiceImp.saveProyectos(proyectos);

        return proyectos;
    }

}