package com.portfolio.api.security.service;

import com.portfolio.api.security.models.Rol;
import com.portfolio.api.security.enums.RolNombre;
import com.portfolio.api.security.repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
@Transactional
public class RolService {
	@Autowired 
	IRolRepository irolRepository;
	
	public Optional<Rol>getByRolNombre(RolNombre rolNombre){
		return irolRepository.findByRolNombre(rolNombre);
	}
	
	public void save(Rol rol){
		irolRepository.save(rol);
	}
}