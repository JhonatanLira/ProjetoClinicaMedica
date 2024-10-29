package com.clinica.domain.dtos;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PacienteDto {

    @Size(max = 100)
    private String nome;
    @Size(min = 11, max = 17)
    private String documento;
    @Size(min = 9, max = 16)
    private String celular;
}
