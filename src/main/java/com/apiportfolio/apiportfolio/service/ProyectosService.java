package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Proyectos;
import com.apiportfolio.apiportfolio.repository.ProyectosRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService implements IProyectosService{
    
    @Autowired
    private ProyectosRepository proyectosrepository;

    @Override
    public List<Proyectos> verProyecto() {
        return proyectosrepository.findAll();
    }

    @Override
    public void crearProyectos(Proyectos proyectos) {
        proyectosrepository.save(proyectos);
    }

    @Override
    public void eliminarProyectos(Integer id) {
        proyectosrepository.deleteById(id);
    }

    @Override
    public Proyectos buscarProyectos(Integer id) {
        return proyectosrepository.findById(id).get();
    }


    
}
