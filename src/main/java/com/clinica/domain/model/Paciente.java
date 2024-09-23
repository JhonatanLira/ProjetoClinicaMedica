package com.clinica.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tb_paiente")
@Data
public class Paciente {

    private Long id;
    private String nome;
    private String cpf;
    private String celular;
    private LocalDate dataCadastro;

}
