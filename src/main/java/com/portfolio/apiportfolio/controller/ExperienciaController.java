package com.portfolio.apiportfolio.controller;

import com.portfolio.apiportfolio.model.Experiencia;
import com.portfolio.apiportfolio.repository.ExperienciaRepo;
import com.portfolio.apiportfolio.service.IExperienciaService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = {"http://localhost:4200", "https://miportfolioweb-e312a.web.app"})
public class ExperienciaController {
	
	@Autowired
	private IExperienciaService experienciaService;	
        
        @Autowired
        private ExperienciaRepo experienciaRepo;

	@GetMapping("/ver")
	@ResponseBody 
	public List<Experiencia> verExperiencia(){
		return experienciaService.verExperiencia();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/nuevo")
	public void agregarExperiencia(@RequestBody Experiencia experiencia){
		experienciaService.crearExperiencia(experiencia);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void eliminarExperiencia(@PathVariable Long id) {
		experienciaService.eliminarExperiencia(id);
	} 
        
        
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Experiencia> editarExperiencia(@PathVariable("id") Long id, @RequestBody Experiencia experiencia) {
        Optional<Experiencia> ExperienciaData = experienciaRepo.findById(id);

        if (ExperienciaData.isPresent()) {
            Experiencia _experiencia = ExperienciaData.get();
            _experiencia.setNombreEmpresa(experiencia.getNombreEmpresa());
            _experiencia.setInicio(experiencia.getInicio());
            _experiencia.setFin(experiencia.getFin());
            _experiencia.setDescripcion(experiencia.getDescripcion());

            return new ResponseEntity<>(experienciaRepo.save(_experiencia), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
//	@PreAuthorize("hasRole('ADMIN')")
//	@PutMapping("/editar/{id}")
//	public Experiencia editarExperiencia(@PathVariable Long id,
//                                @RequestParam("nombreEmpresa") String nuevoNombreEmpresa,
//				@RequestParam("inicio") int nuevoInicio,
//				@RequestParam("fin") int nuevoFin,
//				@RequestParam("descripcion") String nuevaDescripcion){
//        Experiencia experiencia = experienciaService.buscarExperiencia(id);
//        
//        experiencia.setNombreEmpresa(nuevoNombreEmpresa);
//        experiencia.setInicio(nuevoInicio);
//	experiencia.setFin(nuevoFin);
//	experiencia.setDescripcion(nuevaDescripcion);
//        
//       experienciaService.crearExperiencia(experiencia);
//        return experiencia;
//    }	
	
}
