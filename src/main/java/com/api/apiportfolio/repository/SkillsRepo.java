package com.api.apiportfolio.repository;

import com.api.apiportfolio.model.Skills;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository <Skills, Long>{
	 List<Skills> findByTipoSkill(String tipoSkill);
}
