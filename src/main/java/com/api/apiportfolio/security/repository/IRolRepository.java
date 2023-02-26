package com.api.apiportfolio.security.repository;

import com.api.apiportfolio.security.models.Rol;
import com.api.apiportfolio.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository <Rol, Integer>{
	Optional<Rol>findByRolNombre(RolNombre rolNombre);	
}