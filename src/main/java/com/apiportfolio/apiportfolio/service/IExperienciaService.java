package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
	public List <Experiencia> verExperiencia ();
	
	public void crearExperiencia (Experiencia experiencia);
	
	public void eliminarExperiencia (Integer id);
	
	public Experiencia buscarExperiencia (Integer id);
}