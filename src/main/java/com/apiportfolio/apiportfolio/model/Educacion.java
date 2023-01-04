package com.apiportfolio.apiportfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;



@Entity
public class Educacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idEducacion;
    
    @NotNull
    private String institucion;
    
    @NotNull
    private String titulo;
    
    @NotNull
    private int  inicio;
    
    
    private int fin;

    public Educacion() {
    }

    public Educacion(int idEducacion, String institucion, String titulo, int inicio, int fin) {
        this.idEducacion = idEducacion;
        this.institucion = institucion;
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(int idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
    
    
}