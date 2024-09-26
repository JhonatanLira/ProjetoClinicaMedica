package com.clinica.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tb_paiente")
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private String nome;
    @Size(min=11,max = 14)
    private String cpf;
    @Size(min = 9,max = 14)
    private String celular;
    private LocalDate dataCadastro;

}
