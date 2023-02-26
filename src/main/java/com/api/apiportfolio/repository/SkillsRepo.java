package com.api.apiportfolio.repository;

import com.api.apiportfolio.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository <Skills, Long>{
	
}
