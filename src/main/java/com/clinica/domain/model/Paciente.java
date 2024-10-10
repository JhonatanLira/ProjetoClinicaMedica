package com.clinica.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "tb_paciente")
@Data
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private String nome;
    @Size(min = 11, max = 14)
    private String documento;
    @Size(min = 9, max = 14)
    private String celular;

}
