package com.apiportfolio.apiportfolio.controller;

import com.apiportfolio.apiportfolio.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.apiportfolio.apiportfolio.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    public IUsuarioService usuarioservice;
    
    @GetMapping("/ver")
    public List<Usuario> verUsuario(){
        return usuarioservice.verUsuario();
    }
    
    
    @GetMapping("ver/perfil/{id}")
	public Usuario mostrarUsuario(Integer id) {
		return usuarioservice.buscarUsuario(id);
	}
    
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/nuevo")
	public void agregarUsuario(@RequestBody Usuario usuario
	) {
		usuarioservice.crearUsuario(usuario);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void eliminarUsuario(@PathVariable Integer id
	) {
		usuarioservice.eliminarUsuario(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar/{id}")
	public Usuario editarUsuario(@PathVariable Integer id,
		@RequestParam("nombre") String nuevoNombre,
		@RequestParam("apellido") String nuevoApellido,
		@RequestParam("correo") String nuevoCorreo
		
	) {
		Usuario usuario = usuarioservice.buscarUsuario(id);

		usuario.setNombre(nuevoNombre);
		usuario.setApellido(nuevoApellido);
		usuario.setCorreo(nuevoCorreo);

		usuarioservice.crearUsuario(usuario);
		return usuario;
	}
        
}
