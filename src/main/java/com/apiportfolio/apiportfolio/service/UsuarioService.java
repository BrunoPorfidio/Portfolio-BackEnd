package com.apiportfolio.apiportfolio.service;

import com.apiportfolio.apiportfolio.model.Usuario;
import com.apiportfolio.apiportfolio.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private UsuarioRepository usuariorepository;
    
    
    @Override
    public List<Usuario> verUsuario(){
        return usuariorepository.findAll();
    }
    
    @Override
    public void crearUsuario(Usuario usuario){
        usuariorepository.save(usuario);
    }
    
    @Override
    public void eliminarUsuario(Integer id){
        usuariorepository.deleteById(id);
    }
    
    @Override
    public Usuario buscarUsuario(Integer id) {
		Usuario usuario = usuariorepository.findById(id).orElse(null);
		return usuario;
	}
    
}
