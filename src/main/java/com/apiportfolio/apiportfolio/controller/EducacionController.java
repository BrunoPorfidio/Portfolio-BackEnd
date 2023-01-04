package com.apiportfolio.apiportfolio.controller;

import com.apiportfolio.apiportfolio.model.Educacion;
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
import com.apiportfolio.apiportfolio.service.IEducacionService;


@RestController
@RequestMapping("/educacion")
public class EducacionController {

	@Autowired
	private IEducacionService educacionservice;
	
	@GetMapping("/ver")
	@ResponseBody 
	public List<Educacion> verEducacion(){
		return educacionservice.verEducacion();
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/nuevo")
	public void agregarEducacion(@RequestBody Educacion educacion){
		educacionservice.crearEducacion(educacion);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void eliminarUsuario(@PathVariable Integer id) {
		educacionservice.eliminarEducacion(id);	
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar/{id}")
	public Educacion editarEducacion(@PathVariable Integer id,
                                @RequestParam("institucion") String nuevaInstitucion,
				@RequestParam("titulo") String nuevoTitulo,
				@RequestParam("Inicio") int nuevoAnoInicio,
				@RequestParam("Fin") int nuevoAnoFin){
        Educacion educacion = educacionservice.buscarEducacion(id);
        
        educacion.setInstitucion(nuevaInstitucion);
        educacion.setTitulo(nuevoTitulo);
        educacion.setInicio(nuevoAnoInicio);
	educacion.setFin(nuevoAnoFin);
        
       educacionservice.crearEducacion(educacion);
        return educacion;
    }	
    
}
