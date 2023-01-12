package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Educacion;
import com.portfolio.apiportfolio.repository.EducacionRepo;
import com.portfolio.apiportfolio.service.IEducacionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = {"http://localhost:4200", "https://miportfolioweb-e312a.web.app"})
public class EducacionController {
	
	@Autowired
	private IEducacionService educacionService;
        
        @Autowired
        private EducacionRepo educacionRepo;
	
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
    public ResponseEntity<Educacion> editarEducacion(@PathVariable("id") Long id, @RequestBody Educacion educacion) {
        Optional<Educacion> EducacionData = educacionRepo.findById(id);

        if (EducacionData.isPresent()) {
            Educacion _educacion = EducacionData.get();
            _educacion.setInstitucion(educacion.getInstitucion());
            _educacion.setTitulo(educacion.getTitulo());
            _educacion.setInicio(educacion.getInicio());
            _educacion.setFin(educacion.getFin());
            return new ResponseEntity<>(educacionRepo.save(_educacion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
        
//	@PreAuthorize("hasRole('ADMIN')")
//	@PutMapping("/editar/{id}")
//	public Educacion editarEducacion(@PathVariable Long id,
//                                @RequestParam("institucion") String nuevaInstitucion,
//				@RequestParam("titulo") String nuevoTitulo,
//				@RequestParam("inicio") int nuevoInicio,
//				@RequestParam("fin") int nuevoFin){
//        Educacion educacion = educacionService.buscarEducacion(id);
//        
//        educacion.setInstitucion(nuevaInstitucion);
//        educacion.setTitulo(nuevoTitulo);
//        educacion.setInicio(nuevoInicio);
//	educacion.setFin(nuevoFin);
//        
//       educacionService.crearEducacion(educacion);
//        return educacion;
//    }	
}

