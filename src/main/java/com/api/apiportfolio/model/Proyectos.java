package com.api.apiportfolio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Proyectos implements Serializable {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProyectos;
	private String nombreProyecto;
	private String descripcion;
	private String urlProyecto;
        
        @Column(length = 1000)
	private String fotoProyecto;
        
}