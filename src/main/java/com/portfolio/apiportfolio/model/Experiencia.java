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
public class Experiencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExperiencia;
    private String nombreEmpresa;
    private String puesto;
    private String descripcion;
    private int inicio;
    private int fin;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "idExperiencia" )
//    private Persona id_experiencia;

    //Contructores
    public Experiencia() {
    }

    public Experiencia(Long idExperiencia, String nombreEmpresa, String puesto, String descripcion, int inicio, int fin) {
        this.idExperiencia = idExperiencia;
        this.nombreEmpresa = nombreEmpresa;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Long getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(Long idExperiencia) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

