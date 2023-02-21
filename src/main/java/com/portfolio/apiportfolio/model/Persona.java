package com.portfolio.apiportfolio.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nombre;
    private String apellido;
    private String subTitulo;
    private String acercaMi;
    private String urlFoto;
    private String githubUrl;
    private String linkedinUrl;
    private String imgBanner;
    private int telefono;
    private String email;
    private String ubicacion;

    
    
      // Relaciones
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "persona_id", referencedColumnName = "id")
    List<Skills> skills = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    List<Experiencia> experiencia = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    List<Educacion> educacion = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    List<Proyectos> proyectos = new ArrayList<>();
    
    
    //Constructores 
    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String subTitulo, String acercaMi, String urlFoto, String githubUrl, String linkedinUrl, String imgBanner, int telefono, String email, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.subTitulo = subTitulo;
        this.acercaMi = acercaMi;
        this.urlFoto = urlFoto;
        this.githubUrl = githubUrl;
        this.linkedinUrl = linkedinUrl;
        this.imgBanner = imgBanner;
        this.telefono = telefono;
        this.email = email;
        this.ubicacion = ubicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public String getAcercaMi() {
        return acercaMi;
    }

    public void setAcercaMi(String acercaMi) {
        this.acercaMi = acercaMi;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

     // Getter and Setter de las relaciones

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public List<Experiencia> getExperiencia() {
        return experiencia;
    }

    public void setExperiencias(List<Experiencia> experiencia) {
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
