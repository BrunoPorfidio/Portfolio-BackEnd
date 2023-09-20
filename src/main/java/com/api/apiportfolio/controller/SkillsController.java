package com.api.apiportfolio.controller;

import com.api.apiportfolio.service.ISkillsService;
import com.api.apiportfolio.model.Skills;
import com.api.apiportfolio.repository.SkillsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {

    @Autowired
    ISkillsService iskillsService;

    @Autowired
    SkillsRepo skillsRepo;

    @GetMapping("/ver")
    @ResponseBody
    public List<Skills> verSkills() {
        return iskillsService.verSkills();
    }

    @GetMapping("/tipo")
    public List<Skills> VerSkillsPorTipo(@RequestParam(required = false) String tipoSkill) {
        if (tipoSkill != null) {
            return skillsRepo.findByTipoSkill(tipoSkill);
        } else {
            return iskillsService.verSkills();
        }
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public void crearSkills(@RequestBody Skills sills) {
        iskillsService.crearSkills(sills);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void borrarSkills(@PathVariable Long id) {
        iskillsService.eliminarSkills(id);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Skills editarSkills(@PathVariable("id") Long id,
            @RequestBody Skills skills) {
        skills.getIdSkill();

        iskillsService.crearSkills(skills);
        return skills;
    }

    @GetMapping(path = {"/{id}"})
    public Skills listarId(@PathVariable("id") Long id) {
        return iskillsService.buscarSkills(id);
    }
}
