package com.portfolio.apiportfolio.service;

import com.portfolio.apiportfolio.model.Proyectos;
import com.portfolio.apiportfolio.repository.ProyectoRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService implements IProyectoService {

    @Autowired
    public ProyectoRepo proyectoRepo;

    @Override
    public List<Proyectos> verProyecto() {
        return proyectoRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyectos proyecto) {
        proyectoRepo.save(proyecto);
    }

    @Override
    public void eliminarProyecto(Long id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public Proyectos buscarProyecto(Long id) {
        return proyectoRepo.findById(id).orElse(null);
    }

    @Override
    public void getById(Long id) {
        proyectoRepo.findById(id).get();
    }
}
