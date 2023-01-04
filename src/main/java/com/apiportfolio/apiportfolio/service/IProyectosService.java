package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Proyectos;
import java.util.List;


public interface IProyectosService {
	
	public List <Proyectos> verProyecto ();
	
	public void crearProyectos (Proyectos proyectos);
	
	public void eliminarProyectos (Integer id);
	
	public Proyectos buscarProyectos (Integer id);	
}
