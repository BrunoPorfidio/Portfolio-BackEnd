package com.portfolio.apiportfolio.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Persona implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nombre;
	private String apellido;
	private String titulo;
        @Column(length = 255)
	private String acercaMi;
	private String urlFoto;
	private String githubUrl;
        private String likedinUrl;
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
