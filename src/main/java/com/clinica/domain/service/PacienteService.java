package com.clinica.domain.service;

import com.clinica.domain.model.Paciente;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    public List<Paciente> listar();

    public Paciente buscarPaciente(Long id);

    public void salvar(Paciente paciente);

    public void atualizar(Long id, Paciente paciente);

    public void deletar(Long id);

}
