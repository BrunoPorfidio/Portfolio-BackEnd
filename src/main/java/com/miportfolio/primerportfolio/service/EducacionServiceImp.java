package com.miportfolio.primerportfolio.service;

import com.miportfolio.primerportfolio.model.Educacion;
import com.miportfolio.primerportfolio.model.Experiencia;

import java.util.List;

public interface EducacionServiceImp {
    
    List<Educacion> getEducacion();

    // Guardar una persona
    void saveEducacion (Educacion edu);

    // Eliminar una persona
    void deleteEducacion (Integer id);

    // Encontrar una persona por id
    Educacion findEducacion (Integer id);
}
