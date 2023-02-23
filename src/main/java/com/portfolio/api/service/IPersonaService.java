package com.portfolio.api.service;

import com.portfolio.api.model.Persona;
import java.util.List;


public interface IPersonaService {
	
	public List<Persona> verPersonas();
	
	public void crearPersona(Persona persona);
	
	public void eliminarPersona(Long id);
	
	public Persona buscarPersona(Long id);
        
        public void buscarPorId(Long id);
}
