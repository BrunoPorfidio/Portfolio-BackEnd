package com.portfolio.api.service;


import com.portfolio.api.model.Educacion;
import java.util.List;

public interface IEducacionService {
	
	public List <Educacion> verEducacion ();
	
	public void crearEducacion (Educacion educacion);
	
	public void eliminarEducacion (Long id);
	
	public Educacion buscarEducacion (Long id);
        
        public void getById(Long id);
	
}