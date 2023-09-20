package com.api.apiportfolio.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nombre;
    private String apellido;
    private String subTitulo;
    
    @Column(length = 1500)
    private String acercaMi;
    
    private String githubUrl;
    private String linkedinUrl;
    private int telefono;
    private String email;
    private String ubicacion;
    
}