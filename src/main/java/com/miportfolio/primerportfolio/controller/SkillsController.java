package com.miportfolio.primerportfolio.controller;

import com.miportfolio.primerportfolio.model.Skills;
import com.miportfolio.primerportfolio.model.Usuario;
import com.miportfolio.primerportfolio.repository.UsuarioRepository;
import com.miportfolio.primerportfolio.service.SkillsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/edi_mode")
@CrossOrigin(origins = "*")
public class SkillsController {

    @Autowired
    SkillsServiceImp skillsServiceImp;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/skills")
    public List<Skills> getHabilidad(){
        return skillsServiceImp.getSkills();
    }

    @PostMapping("/crear_skills/{id}")
    public String createSkills(@RequestBody Skills skills, @PathVariable Integer id ){

        Usuario usr = usuarioRepository.getById(id);

        usr.getSkills().add(skills);

        skillsServiceImp.saveSkills(skills);

        return "skill creada";
    }

    @DeleteMapping("/eliminar_skill/{id}")
    public String deleteSkills(@PathVariable Integer id){

        skillsServiceImp.deleteSkills(id);

        return "Skill eliminada";
    }

    @PutMapping("/editar_skill")
    public String editarSkills(
            @RequestBody Skills skills
    ){

        skillsServiceImp.saveSkills(skills);

        return "Skill editada";
    }
}
