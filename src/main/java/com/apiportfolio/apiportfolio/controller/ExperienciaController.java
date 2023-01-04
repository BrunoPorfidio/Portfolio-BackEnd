package com.apiportfolio.apiportfolio.controller;


import com.apiportfolio.apiportfolio.model.Experiencia;
import com.apiportfolio.apiportfolio.service.IExperienciaService;
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
@RequestMapping("/experiencia")
public class ExperienciaController {
	
	@Autowired
	private IExperienciaService experienciaservice;		

	@GetMapping("/ver")
	@ResponseBody 
	public List<Experiencia> verExperiencia(){
		return experienciaservice.verExperiencia();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/nuevo")
	public void agregarExperiencia(@RequestBody Experiencia experiencia){
		experienciaservice.crearExperiencia(experiencia);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void eliminarExperiencia(@PathVariable Integer id) {
		experienciaservice.eliminarExperiencia(id);
	} 
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar/{id}")
	public Experiencia editarExperiencia(@PathVariable Integer id,
                                @RequestParam("nombrEempresa") String nuevoNombreEmpresa,
                                @RequestParam("puesto") String nuevoPuesto,
				@RequestParam("descripcion") String nuevaDescripcion,
				@RequestParam("inicio") int nuevoInicio,
				@RequestParam("fin") int nuevoFin){
        Experiencia experiencia = experienciaservice.buscarExperiencia(id);
        
        experiencia.setNombreEmpresa(nuevoNombreEmpresa);
        experiencia.setInicio(nuevoInicio);
	experiencia.setFin(nuevoFin);
	experiencia.setDescripcion(nuevaDescripcion);
        
       experienciaservice.crearExperiencia(experiencia);
        return experiencia;
    }	
	
}
