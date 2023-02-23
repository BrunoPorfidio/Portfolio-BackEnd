package com.portfolio.api.controller;

import com.portfolio.api.model.Persona;
import com.portfolio.api.model.Skills;
import com.portfolio.api.repository.PersonaRepo;
import com.portfolio.api.repository.SkillsRepo;
import com.portfolio.api.service.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skills")
@CrossOrigin (origins="*")
public class SkillsController {

    @Autowired
    private ISkillsService skillsService;

    @Autowired
    private SkillsRepo skillsRepo;

    @Autowired
    private PersonaRepo personaRepo;

    @GetMapping("/ver")
    @ResponseBody
    public List<Skills> verSkills() {
        return skillsService.verSkills();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo/{id}")
    public String agregarSkills(@RequestBody Skills skills, @PathVariable Long id) {

        Persona pers = personaRepo.getById(id);
        pers.getSkills().add(skills);
        skillsService.crearSkills(skills);
        
        return "Skill Creada";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String eliminarSkills(@PathVariable Long id) {
        skillsService.eliminarSkills(id);
    
        return "Skill Elimina";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public Skills editarSkills(@RequestBody Skills skills){
        skillsService.crearSkills(skills);
        return skills;
    }
    
//        @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/editar/{id}")
//    public ResponseEntity<Skills> editarSkill(@PathVariable Long id, @RequestBody Skills skill) {
//        Skills skills = skillsRepo.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("No se encontro Skill con el ID" + id));
//        skills.setNombreSkill(skill.getNombreSkill());
//        skills.setFotoSkill(skill.getFotoSkill());
//
//        Skills guardarSkills = skillsRepo.save(skill);
//        return ResponseEntity.ok(guardarSkills);
//    }
}