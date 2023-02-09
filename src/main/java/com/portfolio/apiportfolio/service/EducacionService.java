package com.portfolio.apiportfolio.service;

import com.portfolio.apiportfolio.model.Educacion;
import com.portfolio.apiportfolio.repository.EducacionRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class EducacionService implements IEducacionService {
	
	
	@Autowired
	public EducacionRepo educacionRepo;

	@Override
	public List<Educacion> verEducacion() {
		return educacionRepo.findAll();	
	}

	@Override
	public void crearEducacion(Educacion educacion) {
		educacionRepo.save(educacion);
	}

	@Override
	public void eliminarEducacion(Long id) {
		educacionRepo.deleteById(id);	
	}

	@Override
	public Educacion buscarEducacion(Long id) {
		return educacionRepo.findById(id).orElse(null);
	}
        
        @Override
        public void getById(Long id) {
                educacionRepo.findById(id).get();
    }
}
