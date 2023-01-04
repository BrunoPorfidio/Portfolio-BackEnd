package com.apiportfolio.apiportfolio.repository;

import com.apiportfolio.apiportfolio.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Integer> {
    
}
