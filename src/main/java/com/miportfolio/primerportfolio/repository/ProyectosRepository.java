package com.miportfolio.primerportfolio.repository;


import com.miportfolio.primerportfolio.model.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos, Integer> {
    
    
}
