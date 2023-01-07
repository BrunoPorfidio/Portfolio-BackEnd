package com.portfolio.apiportfolio.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proyectos implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProyectos;
	private String nombreProyecto;
	private String descripcion;
	private String url;
	private String fotoProyecto;
        
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "idProyectos" )
//    private Persona id_proyectos;


	//Contructores
	public Proyectos() {
	}

    public Proyectos(Long idProyectos, String nombreProyecto, String descripcion, String url, String fotoProyecto) {
        this.idProyectos = idProyectos;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.url = url;
        this.fotoProyecto = fotoProyecto;
    }

    public Long getIdProyectos() {
        return idProyectos;
    }

    public void setIdProyectos(Long idProyectos) {
        this.idProyectos = idProyectos;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFotoProyecto() {
        return fotoProyecto;
    }

    public void setFotoProyecto(String fotoProyecto) {
        this.fotoProyecto = fotoProyecto;
    }

	
}
