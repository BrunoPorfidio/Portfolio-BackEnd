package com.portfolio.api.security.repository;

import com.portfolio.api.security.models.Rol;
import com.portfolio.api.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository <Rol, Integer>{
	Optional<Rol>findByRolNombre(RolNombre rolNombre);	
}