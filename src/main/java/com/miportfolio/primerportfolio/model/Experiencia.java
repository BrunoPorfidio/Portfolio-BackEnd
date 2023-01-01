package com.miportfolio.primerportfolio.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Experiencia {
    
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
    private String inicio;
    
    private String fin;

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

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
    
    
    
}
