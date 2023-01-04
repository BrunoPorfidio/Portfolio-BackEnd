package com.apiportfolio.apiportfolio.repository;

import com.apiportfolio.apiportfolio.model.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends JpaRepository <Proyectos, Integer> {
    
}
