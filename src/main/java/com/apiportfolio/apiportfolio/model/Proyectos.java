package com.apiportfolio.apiportfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Proyectos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idProyectos;
    
    @NotNull
    private String tituloProyecto;
    
    @NotNull
    private String descripcionProyecto;
    
    @NotNull
    private String fotoProyecto;
    
    @NotNull
    private String urlProyecto;

    public Proyectos() {
    }

    public Proyectos(int idProyectos, String tituloProyecto, String descripcionProyecto, String fotoProyecto, String urlProyecto) {
        this.idProyectos = idProyectos;
        this.tituloProyecto = tituloProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.fotoProyecto = fotoProyecto;
        this.urlProyecto = urlProyecto;
    }

    public int getIdProyectos() {
        return idProyectos;
    }

    public void setIdProyectos(int idProyectos) {
        this.idProyectos = idProyectos;
    }

    public String getTituloProyecto() {
        return tituloProyecto;
    }

    public void setTituloProyecto(String tituloProyecto) {
        this.tituloProyecto = tituloProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getFotoProyecto() {
        return fotoProyecto;
    }

    public void setFotoProyecto(String fotoProyecto) {
        this.fotoProyecto = fotoProyecto;
    }

    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }
    
    
}
