package com.clinica.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "tb_patient")
@Data
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String name;
    @Size(min = 11, max = 14)
    private String document;
    @Size(min = 9, max = 14)
    private String cellphone;

}
