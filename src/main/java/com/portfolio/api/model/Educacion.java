package com.portfolio.api.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEducacion;
    private String institucion;
    private String titulo;
    private int inicio;
    private int fin;
    private String fotoEducacion;

    //Contructores 
    public Educacion() {
    }

    public Educacion(Long idEducacion, String institucion, String titulo, int inicio, int fin, String fotoEducacion) {
        this.idEducacion = idEducacion;
        this.institucion = institucion;
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.fotoEducacion = fotoEducacion;
    }

    //Getters and Setters
    public Long getidEducacion() {
        return idEducacion;
    }

    public void setidEducacion(Long idEducacion) {
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

    public void setInicio(int anoInicio) {
        this.inicio = anoInicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public String getFotoEducacion() {
        return fotoEducacion;
    }

    public void setFotoEducacion(String fotoEducacion) {
        this.fotoEducacion = fotoEducacion;
    }

}