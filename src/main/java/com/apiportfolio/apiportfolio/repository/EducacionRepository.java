package com.apiportfolio.apiportfolio.repository;

import com.apiportfolio.apiportfolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository <Educacion, Integer> {
    
}
