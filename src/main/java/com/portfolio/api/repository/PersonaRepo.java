package com.portfolio.api.repository;

import com.portfolio.api.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository <Persona, Long>{
	
}
