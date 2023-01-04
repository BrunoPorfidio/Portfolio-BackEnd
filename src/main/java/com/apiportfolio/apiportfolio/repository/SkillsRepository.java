package com.apiportfolio.apiportfolio.repository;

import com.apiportfolio.apiportfolio.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository <Skills, Integer> {
    
}