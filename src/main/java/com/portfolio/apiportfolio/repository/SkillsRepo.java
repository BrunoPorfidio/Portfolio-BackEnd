package com.portfolio.apiportfolio.repository;

import com.portfolio.apiportfolio.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository <Skills, Long>{
	
}
