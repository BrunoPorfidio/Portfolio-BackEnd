package com.api.apiportfolio.service;

import com.api.apiportfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {
	
	public List <Educacion> verEducacion ();
	
	public void crearEducacion (Educacion educacion);
	
	public void eliminarEducacion (Long id);
	
	public Educacion buscarEducacion (Long id);
	
}