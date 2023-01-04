package com.apiportfolio.apiportfolio.controller;

import com.apiportfolio.apiportfolio.model.Usuario;
import com.apiportfolio.apiportfolio.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired
    public UsuarioService usuarioservice;
    
    @GetMapping("/ver")
    public List<Usuario> verUsuario(){
        return usuarioservice.verUsuario();
    }
    
    
    @GetMapping("ver/perfil/{id}")
	public Usuario mostrarUsuario(Integer id) {
		return usuarioservice.buscarUsuario(id);
	}
    
    
}
