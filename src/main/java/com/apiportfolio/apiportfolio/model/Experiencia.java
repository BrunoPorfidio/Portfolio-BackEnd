package com.apiportfolio.apiportfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Experiencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idExperiencia;
    
    
    @NotNull
    private String nombreEmpresa;
    
    @NotNull
    private String puesto;
    
    @NotNull
    private String descripcion;
    
    @NotNull
    private int inicio;
    
    private int fin;

    public Experiencia() {
    }

    public Experiencia(int idExperiencia, String nombreEmpresa, String puesto, String descripcion, int inicio, int fin) {
        this.idExperiencia = idExperiencia;
        this.nombreEmpresa = nombreEmpresa;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(int idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
