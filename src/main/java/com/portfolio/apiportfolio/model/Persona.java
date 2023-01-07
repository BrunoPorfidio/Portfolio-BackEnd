package com.portfolio.apiportfolio.model;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private String acercaMi;
	private String urlFoto;
	private String githubUrl;
        private String likedinUrl;
	private String imgBanner;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
	private List<Educacion> educacionList;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
	private List<Experiencia> experienciaList;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idProy")
	private List<Proyectos> proyectoList;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idSkill")
	private List<Skills> SkillsList;
	
	 
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
