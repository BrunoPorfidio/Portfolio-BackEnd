package com.apiportfolio.apiportfolio.controller;

import com.apiportfolio.apiportfolio.model.Skills;
import com.apiportfolio.apiportfolio.service.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class SkillsController {
	
	@Autowired
	private ISkillsService skillsservice;
	
	@GetMapping("/ver")
	@ResponseBody 
	public List<Skills> verSkills(){
		return skillsservice.verSkills();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/nuevo")
	public void agregarSkills(@RequestBody Skills skills){
		skillsservice.crearSkills(skills);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void eliminarSkills(@PathVariable Integer id) {
		skillsservice.eliminarSkills(id);
	} 
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar/{id}")
    public Skills editarSkills(@PathVariable Integer id,
                                @RequestParam("nombreSkill") String nuevoNombre,
				@RequestParam("fotoSkill") String nuevaFoto){
        Skills skills = skillsservice.buscarSkills(id);
        
        skills.setNombreSkill(nuevoNombre);
        skills.setFotoSkill(nuevaFoto);
        
       skillsservice.crearSkills(skills);
        return skills;
    }
}
