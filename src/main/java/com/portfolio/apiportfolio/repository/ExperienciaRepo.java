package com.portfolio.apiportfolio.repository;

import com.portfolio.apiportfolio.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepo extends JpaRepository <Experiencia, Long>{
	
}
