package com.api.apiportfolio.model;

import java.io.Serializable;
import java.time.YearMonth;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Educacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEducacion;
    private String institucion;
    private String titulo;
    private YearMonth inicio;
    private YearMonth fin;
    
    @Column(length = 1000)
    private String fotoEducacion;

}
