package com.clinica.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_medico")
@Data
public class Medico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;
    @Size(min = 3, max = 80)
    private String nome;
    @Size(min = 3, max = 20)
    private String crm;
    private String uf;
    @OneToMany
    private List<Especialidade> especialidades;

}
