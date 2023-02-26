package com.api.apiportfolio.service;

import com.api.apiportfolio.model.Proyectos;
import java.util.List;

public interface IProyectoService {
	
	public List <Proyectos> verProyecto ();
	
	public void crearProyecto (Proyectos proyecto);
	
	public void eliminarProyecto (Long id);
	
	public Proyectos buscarProyecto (Long id);
        
        public void getById(Long id);
}