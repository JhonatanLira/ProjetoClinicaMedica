package com.clinica.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tb_medico")
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;
    private Long idEspecialidade;
    @Size(min = 3,max = 80)
    private String nome;
    @Size(min = 3,max = 11)
    private String crm;

}
