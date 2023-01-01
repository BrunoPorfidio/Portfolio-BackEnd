package com.miportfolio.primerportfolio.service;


import com.miportfolio.primerportfolio.model.Usuario;
import com.miportfolio.primerportfolio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UsuarioServiceImp{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public void saveUsuario(Usuario usu) {
        usuarioRepository.save(usu);
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
