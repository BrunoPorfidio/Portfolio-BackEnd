package com.portfolio.api.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos implements Serializable {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProyectos;
	private String nombreProyecto;
	private String descripcion;
	private String urlProyecto;
	private String fotoProyecto;
        

	//Contructores
	public Proyectos() {
	}

    public Proyectos(Long idProyectos, String nombreProyecto, String descripcion, String urlProyecto, String fotoProyecto) {
        this.idProyectos = idProyectos;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.urlProyecto = urlProyecto;
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

    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }

    public String getFotoProyecto() {
        return fotoProyecto;
    }

    public void setFotoProyecto(String fotoProyecto) {
        this.fotoProyecto = fotoProyecto;
    }

}