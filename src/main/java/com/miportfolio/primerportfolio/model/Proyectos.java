package com.miportfolio.primerportfolio.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Proyectos {
    
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
