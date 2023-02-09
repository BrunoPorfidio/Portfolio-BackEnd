package com.portfolio.apiportfolio.repository;


import com.portfolio.apiportfolio.model.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepo extends JpaRepository <Proyectos, Long> {
	
}
