package com.apiportfolio.apiportfolio.model;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idSkills;
    
    @NotNull
    private String nombreSkill;
    
    @NotNull
    private String fotoSkill;

    public Skills() {
    }

    public Skills(int idSkills, String nombreSkill, String fotoSkill) {
        this.idSkills = idSkills;
        this.nombreSkill = nombreSkill;
        this.fotoSkill = fotoSkill;
    }

    public int getIdSkills() {
        return idSkills;
    }

    public void setIdSkills(int idSkills) {
        this.idSkills = idSkills;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getFotoSkill() {
        return fotoSkill;
    }

    public void setFotoSkill(String fotoSkill) {
        this.fotoSkill = fotoSkill;
    }
    
    
}
