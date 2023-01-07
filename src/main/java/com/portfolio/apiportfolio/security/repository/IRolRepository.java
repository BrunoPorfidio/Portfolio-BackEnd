package com.portfolio.apiportfolio.security.repository;

import com.portfolio.apiportfolio.security.models.Rol;
import com.portfolio.apiportfolio.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository <Rol, Integer>{
	Optional<Rol>findByRolNombre(RolNombre rolNombre);	
}
