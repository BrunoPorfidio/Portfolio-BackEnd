package com.portfolio.api.service;

import com.portfolio.api.model.Proyectos;
import java.util.List;


public interface IProyectoService {
	
	public List <Proyectos> verProyecto ();
	
	public void crearProyecto (Proyectos proyecto);
	
	public void eliminarProyecto (Long id);
	
	public Proyectos buscarProyecto (Long id);
        
        public void getById(Long id);
}
