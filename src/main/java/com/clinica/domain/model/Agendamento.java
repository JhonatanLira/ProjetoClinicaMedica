package com.clinica.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tb_scheduling")
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgendamento;
    private String data;
    private String hora;
    private LocalDate dataRegistro;
    @OneToOne
    private Paciente paciente;
    @OneToOne
    private Medico medico;


}
