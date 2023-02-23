package com.portfolio.api.repository;

import com.portfolio.api.model.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepo extends JpaRepository <Proyectos, Long> {
	
}