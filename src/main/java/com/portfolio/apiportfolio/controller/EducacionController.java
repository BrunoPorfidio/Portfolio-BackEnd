package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Educacion;
import com.portfolio.apiportfolio.service.IEducacionService;
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
@RequestMapping("/educacion")
public class EducacionController {
	
	@Autowired
	private IEducacionService educacionService;
	
	@GetMapping("/ver")
	@ResponseBody 
	public List<Educacion> verEducacion(){
		return educacionService.verEducacion();
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/nuevo")
	public void agregarEducacion(@RequestBody Educacion educacion){
		educacionService.crearEducacion(educacion);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void eliminarUsuario(@PathVariable Long id) {
		educacionService.eliminarEducacion(id);	
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar/{id}")
	public Educacion editarEducacion(@PathVariable Long id,
                                @RequestParam("institucion") String nuevaInstitucion,
				@RequestParam("titulo") String nuevoTitulo,
				@RequestParam("Inicio") int nuevoInicio,
				@RequestParam("Fin") int nuevoFin){
        Educacion educacion = educacionService.buscarEducacion(id);
        
        educacion.setInstitucion(nuevaInstitucion);
        educacion.setTitulo(nuevoTitulo);
        educacion.setInicio(nuevoInicio);
	educacion.setFin(nuevoFin);
        
       educacionService.crearEducacion(educacion);
        return educacion;
    }	
}
