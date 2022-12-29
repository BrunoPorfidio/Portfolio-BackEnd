
package com.miportfolio.primerportfolio.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String correo, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = contrasenia;
    }
}
