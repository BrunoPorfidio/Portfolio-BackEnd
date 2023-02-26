package com.api.apiportfolio.service;

import com.api.apiportfolio.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
	public List <Experiencia> verExperiencia ();
	
	public void crearExperiencia (Experiencia experiencia);
	
	public void eliminarExperiencia (Long id);
	
	public Experiencia buscarExperiencia (Long id);
        
        public void getById(Long id);
}