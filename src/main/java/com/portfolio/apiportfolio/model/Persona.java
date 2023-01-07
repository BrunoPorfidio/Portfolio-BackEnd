package com.portfolio.apiportfolio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String titulo;
    @Size(min = 1, max = 255, message = "no cumple con la longitud")
    private String acercaMi;
    @Size(min = 1, max = 255, message = "no cumple con la longitud")
    private String urlFoto;
    @Size(min = 1, max = 255, message = "no cumple con la longitud")
    private String githubUrl;
    @Size(min = 1, max = 255, message = "no cumple con la longitud")
    private String likedinUrl;
    @Size(min = 1, max = 255, message = "no cumple con la longitud")
    private String imgBanner;

//        @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_educacion")
//         List<Educacion> educacion = new ArrayList<>();
//        @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_experiencia")
//         List<Experiencia> experiencias = new ArrayList<>();
//        @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_proyectos")
//         List<Proyectos> proyectos = new ArrayList<>();
//        @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_skills")
//         List<Skills> skills = new ArrayList<>();
    //Constructores 
    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String titulo, String acercaMi, String urlFoto, String likedinUrl, String githubUrl, String imgBanner) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.acercaMi = acercaMi;
        this.urlFoto = urlFoto;
        this.likedinUrl = likedinUrl;
        this.githubUrl = githubUrl;
        this.imgBanner = imgBanner;
    }

    //Getters and Setters
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

    public String getLikedinUrl() {
        return likedinUrl;
    }

    public void setLikedinUrl(String likedinUrl) {
        this.likedinUrl = likedinUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

}
