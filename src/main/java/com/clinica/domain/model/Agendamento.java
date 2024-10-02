package com.clinica.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_agendamento")
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data;
    private String hora;
    //@OneToOne
    private Long idPaciente;
    //@OneToOne
    private Long idMedico;

}
