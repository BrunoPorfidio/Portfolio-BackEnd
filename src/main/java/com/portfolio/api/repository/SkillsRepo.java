package com.portfolio.api.repository;

import com.portfolio.api.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository <Skills, Long>{
	
}
