package com.api.apiportfolio.repository;

import com.api.apiportfolio.model.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepo extends JpaRepository <Proyectos, Long> {
	
}
