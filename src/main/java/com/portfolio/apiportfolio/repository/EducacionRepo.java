package com.portfolio.apiportfolio.repository;

import com.portfolio.apiportfolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepo extends JpaRepository <Educacion, Long> {
	
}