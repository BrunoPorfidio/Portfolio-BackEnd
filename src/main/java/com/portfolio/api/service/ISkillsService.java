package com.portfolio.api.service;

import com.portfolio.api.model.Skills;
import java.util.List;


public interface ISkillsService {
	public List <Skills> verSkills ();
	
	public void crearSkills (Skills skills);
	
	public void eliminarSkills (Long id);
	
	public Skills buscarSkills (Long id);	
        
        public void buscarPorId(Long id);
	
}