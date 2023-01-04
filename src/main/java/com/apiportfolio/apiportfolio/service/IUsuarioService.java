package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    
        public List<Usuario> verUsuario();
    
	public void crearUsuario(Usuario usuario);
	
	public void eliminarUsuario(Integer id);
	
	public Usuario buscarUsuario(Integer id);
}


