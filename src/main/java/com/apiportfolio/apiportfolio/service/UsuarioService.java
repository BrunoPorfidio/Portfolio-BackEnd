package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Usuario;
import com.apiportfolio.apiportfolio.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuariorepository;
    
    
    public List<Usuario> verUsuario(){
        return usuariorepository.findAll();
    }
    
    public void crearUsuario(Usuario usuario){
        usuariorepository.save(usuario);
    }
    
    public Usuario obtenerUsuario(Integer id){
        return usuariorepository.findById(id).get();
    }
    
    public void eliminarUsuario(Integer id){
        usuariorepository.deleteById(id);
    }
    
    public Usuario buscarUsuario(Integer id) {
		Usuario usuario = usuariorepository.findById(id).orElse(null);
		return usuario;
	}
    
}
