package com.miportfolio.primerportfolio.service;


import com.miportfolio.primerportfolio.model.Proyectos;
import com.miportfolio.primerportfolio.repository.ProyectosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectosService implements ProyectosServiceImp {
    
    @Autowired
    ProyectosRepository proyectoRrepository;

    @Override
    public List<Proyectos> getProyectos() {
        return proyectoRrepository.findAll();
    }

    @Override
    public void saveProyectos(Proyectos proyectos) {
        proyectoRrepository.save(proyectos);
    }

    @Override
    public void deleteProyectos(Integer id) {
        proyectoRrepository.deleteById(id);
    }

    @Override
    public Proyectos findProyectos (Integer id) {
        return (Proyectos) proyectoRrepository.findById(id).orElse(null);
    }
}
