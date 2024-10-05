package com.clinica.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tb_scheduling")
@Data
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idScheduling;
    private String dateScheduling;
    private String horaScheduling;
   //@OneToOne
    private Patient patient;
   //@OneToOne
    private Doctor doctor;
    private LocalDate registrationDate;


}
