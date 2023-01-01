
package com.miportfolio.primerportfolio.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idUsuario;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    
    @NotNull
    private String correo;
    
    @NotNull
    private String password;
    
    @Column(length = 1000)
    @NotNull
    private String Sobre_Mi;
    
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_persona", referencedColumnName = "id_Persona")
    List<Skills> skills = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", referencedColumnName = "id_Persona")
    List<Experiencia> experiencia = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", referencedColumnName = "id_Persona")
    List<Educacion> educacion = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", referencedColumnName = "id_Persona")
    List<Proyectos> proyectos = new ArrayList<>();
    
    

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String apellido, String correo, String contrasenia) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = contrasenia;
    }
    
    public Usuario(List<Skills> skills){
        this.skills = skills;
    }

    public int getId() {
        return idUsuario;
    }

    public void setId(int id_Usuario) {
        this.idUsuario = id_Usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSobre_Mi() {
        return Sobre_Mi;
    }

    public void setSobre_Mi(String Sobre_Mi) {
        this.Sobre_Mi = Sobre_Mi;
    }
    
    
    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public List<Experiencia> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(List<Experiencia> experiencia) {
        this.experiencia = experiencia;
    }

    public List<Educacion> getEducacion() {
        return educacion;
    }

    public void setEducacion(List<Educacion> educacion) {
        this.educacion = educacion;
    }

    public List<Proyectos> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyectos> proyectos) {
        this.proyectos = proyectos;
    }
    
}
