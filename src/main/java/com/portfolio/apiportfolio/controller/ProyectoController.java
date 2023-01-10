package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Proyectos;
import com.portfolio.apiportfolio.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = {"http://localhost:4200", "https://miportfolioweb-e312a.web.app"})
public class ProyectoController {
	
	@Autowired
	private IProyectoService proyectoService;
	
	@GetMapping("/ver")
	@ResponseBody 
	public List<Proyectos> verProyecto(){
		return proyectoService.verProyecto();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/nuevo")
	public void agregarProyecto(@RequestBody Proyectos proyecto){
		proyectoService.crearProyecto(proyecto);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void eliminarProyecto(@PathVariable Long id) {
		proyectoService.eliminarProyecto(id);
	} 
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar/{id}")
	public Proyectos editarProyecto(@PathVariable Long id,
                                @RequestParam("nombreProyecto") String nuevaNombreProyecto,
				@RequestParam("descripcion") String nuevaDescripcion,
				@RequestParam("url") String nuevaUrl,
				@RequestParam("fotoProyecto") String nuevaFotoProyecto){
        Proyectos proyecto = proyectoService.buscarProyecto(id);
        
	proyecto.setNombreProyecto(nuevaNombreProyecto);
	proyecto.setDescripcion(nuevaDescripcion);
	proyecto.setUrl(nuevaUrl);
	proyecto.setFotoProyecto(nuevaFotoProyecto);
		
	proyectoService.crearProyecto(proyecto);
        return proyecto;
    }	
	
}
