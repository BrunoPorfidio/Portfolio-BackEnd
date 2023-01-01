package com.miportfolio.primerportfolio.service;

import com.miportfolio.primerportfolio.model.Proyectos;

import java.util.List;

public interface ProyectosServiceImp{
    
    
    List<Proyectos> getProyectos();


    void saveProyectos (Proyectos proyectos);


    void deleteProyectos (Integer id);


    Proyectos findProyectos (Integer id);

    
}
