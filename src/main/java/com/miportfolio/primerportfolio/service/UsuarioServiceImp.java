package com.miportfolio.primerportfolio.service;

import com.miportfolio.primerportfolio.model.Usuario;

import java.util.List;


public interface UsuarioServiceImp {
    
    List <Usuario> getUsuario();

    // Guardar una persona
    void saveUsuario (Usuario pers);

    // Eliminar una persona
    void deleteUsuario (Integer id);

    // Encontrar una persona por id
    Usuario findUsuario (Integer id);
    
}
