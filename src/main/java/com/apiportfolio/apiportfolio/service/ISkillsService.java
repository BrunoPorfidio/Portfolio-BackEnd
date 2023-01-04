package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Skills;
import java.util.List;


public interface ISkillsService {
	public List <Skills> verSkills ();
	
	public void crearSkills (Skills skills);
	
	public void eliminarSkills (Integer id);
	
	public Skills buscarSkills (Integer id);	
	
}
