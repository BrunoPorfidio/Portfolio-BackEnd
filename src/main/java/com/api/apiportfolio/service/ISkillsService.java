package com.api.apiportfolio.service;

import com.api.apiportfolio.model.Skills;
import java.util.List;


public interface ISkillsService {
	public List <Skills> verSkills ();
	
	public void crearSkills (Skills skills);
	
	public void eliminarSkills (Long id);
	
	public Skills buscarSkills (Long id);	
        
        public void buscarPorId(Long id);
	
}
