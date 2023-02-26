package com.api.apiportfolio.service;

import com.api.apiportfolio.model.Persona;
import java.util.List;


public interface IPersonaService {
	
	public List<Persona> verPersonas();
	
	public void crearPersona(Persona persona);
	
	public void eliminarPersona(Long id);
	
	public Persona buscarPersona(Long id);
        
        public void buscarPorId(Long id);
}
