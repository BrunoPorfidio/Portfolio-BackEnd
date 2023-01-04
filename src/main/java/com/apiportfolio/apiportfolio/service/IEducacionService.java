package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {
	
	public List <Educacion> verEducacion ();
	
	public void crearEducacion (Educacion educacion);
	
	public void eliminarEducacion (Integer id);
	
	public Educacion buscarEducacion (Integer id);
	
}
