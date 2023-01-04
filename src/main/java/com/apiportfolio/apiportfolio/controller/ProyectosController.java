package com.apiportfolio.apiportfolio.controller;

import com.apiportfolio.apiportfolio.model.Proyectos;
import com.apiportfolio.apiportfolio.service.IProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
public class ProyectosController {
	
	@Autowired
	private IProyectosService proyectosservice;
	
	@GetMapping("/ver")
	@ResponseBody 
	public List<Proyectos> verProyectos(){
		return proyectosservice.verProyecto();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/nuevo")
	public void agregarProyectos(@RequestBody Proyectos proyectos){
		proyectosservice.crearProyectos(proyectos);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void eliminarProyectos(@PathVariable Integer id) {
		proyectosservice.eliminarProyectos(id);
	} 
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar/{id}")
	public Proyectos editarProyectos(@PathVariable Integer id,
                                @RequestParam("tituloProyecto") String nuevoTituloProyecto,
				@RequestParam("descripcionProyecto") String nuevaDescripcionProyecto,
				@RequestParam("fotoProyecto") String nuevaFotoProyecto,
				@RequestParam("urlproyecto") String nuevaUrlProyecto){
        Proyectos proyectos = proyectosservice.buscarProyectos(id);
        
	proyectos.setTituloProyecto(nuevoTituloProyecto);
	proyectos.setDescripcionProyecto(nuevaDescripcionProyecto);
	proyectos.setUrlProyecto(nuevaUrlProyecto);
	proyectos.setFotoProyecto(nuevaFotoProyecto);
		
	proyectosservice.crearProyectos(proyectos);
        return proyectos;
    }	
	
}