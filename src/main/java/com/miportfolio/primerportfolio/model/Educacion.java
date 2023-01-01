package com.miportfolio.primerportfolio.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Educacion {
    
    
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
