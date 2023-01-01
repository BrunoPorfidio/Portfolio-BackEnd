package com.miportfolio.primerportfolio.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Skills {
    
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

    public void setIdSkills(int id_Skills) {
        this.idSkills = id_Skills;
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
