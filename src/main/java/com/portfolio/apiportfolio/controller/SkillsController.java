package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Skills;
import com.portfolio.apiportfolio.repository.SkillsRepo;
import com.portfolio.apiportfolio.service.ISkillsService;
import java.util.List;
import java.util.Optional;
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
    @PutMapping("/editar/{id}")
    public ResponseEntity<Skills> editarProyectos(@PathVariable("id") Long id, @RequestBody Skills proyectos) {
        Optional<Skills> SkillsData = skillsRepo.findById(id);

        if (SkillsData.isPresent()) {
            Skills _skills = SkillsData.get();
            _skills.setNombreSkill(proyectos.getNombreSkill());
            _skills.setFotoSkill(proyectos.getFotoSkill());

            return new ResponseEntity<>(skillsRepo.save(_skills), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
