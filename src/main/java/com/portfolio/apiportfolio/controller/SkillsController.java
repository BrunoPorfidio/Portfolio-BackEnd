package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Skills;
import com.portfolio.apiportfolio.repository.SkillsRepo;
import com.portfolio.apiportfolio.service.ISkillsService;
import java.util.List;
import java.util.Optional;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/skills")
@CrossOrigin(origins = {"http://localhost:4200", "https://miportfolioweb-e312a.web.app"})
public class SkillsController {

    @Autowired
    private ISkillsService skillsService;

    @Autowired
    private SkillsRepo skillsRepo;

    @GetMapping("/ver")
    @ResponseBody
    public List<Skills> verSkills() {
        return skillsService.verSkills();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Skills> obtenerSkillPorId(@PathVariable Long id){
           Skills skills = skillsRepo.findById(id)
                   .orElseThrow(() -> new ResourceNotFoundException("No se encontreo Skill con el ID" + id));
                   
           return ResponseEntity.ok(skills);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public void agregarSkills(@RequestBody Skills skills) {
        skillsService.crearSkills(skills);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void eliminarSkills(@PathVariable Long id) {
        skillsService.eliminarSkills(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public String editarSkills(@RequestBody Skills skills){

        skillsService.crearSkills(skills);

        return "Skill editada";
    }
        
        
//                public ResponseEntity<Skills> editarSkill(@PathVariable Long id, @RequestBody Skills skill){
//           Skills skills = skillsRepo.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("No se encontro Skill con el ID" + id));
//           skills.setNombreSkill(skill.getNombreSkill());
//           skills.setFotoSkill(skill.getFotoSkill());
//           
//           Skills guardarSkills = skillsRepo.save(skill);
//           return ResponseEntity.ok(guardarSkills);
//    }

}
