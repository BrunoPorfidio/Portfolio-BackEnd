package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Proyectos;
import com.apiportfolio.apiportfolio.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService {
    
    @Autowired
    private ProyectosRepository proyectosrepository;
    
    public List<Proyectos> verProyectos(){
        return proyectosrepository.findAll();
    }
    
    public void crearProyectos(Proyectos proyectos){
        proyectosrepository.save(proyectos);
    }
    
    public Proyectos obtenerProyectos(Integer id){
        return proyectosrepository.findById(id).get();
    }
    
    public void eliminarProyectos(Integer id){
        proyectosrepository.deleteById(id);
    }
    
}
