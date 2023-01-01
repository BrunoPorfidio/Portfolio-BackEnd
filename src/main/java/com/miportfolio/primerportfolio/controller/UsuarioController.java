package com.miportfolio.primerportfolio.controller;

import com.miportfolio.primerportfolio.model.Usuario;
import com.miportfolio.primerportfolio.service.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/edit_mode")
@CrossOrigin(origins = "*")
public class UsuarioController {
    
    @Autowired
    private UsuarioServiceImp usuarioServiceImp;
    
    @GetMapping("/usuario")
    public ResponseEntity <List<Usuario>> getUsuario(){
        List<Usuario> usuario = usuarioServiceImp.getUsuario();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
    @GetMapping("/usuario_uno/{id}")
    public Usuario getOneUsuario(@PathVariable Integer id){
        return usuarioServiceImp.findUsuario(id);
    }
    
    @PostMapping("/crear_usuario")
    public String createUsuario(@RequestBody Usuario usr){
        usuarioServiceImp.saveUsuario(usr);
        return "Usuario Creado";
    }
    
    
   @DeleteMapping("/eliminar_usuario{id}")
   public String deleteUsuario(@PathVariable Integer id){
       usuarioServiceImp.deleteUsuario(id);
       return "Usuario Eliminado";
   }
    
   @PutMapping("/editar_usuario")
   public Usuario editarUsuario(
   @RequestBody Usuario usuario
   ){
       usuarioServiceImp.saveUsuario(usuario);
       return usuario;
   }
    
    
    
}
