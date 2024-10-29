package com.clinica.domain.service;

import com.clinica.domain.model.Paciente;

import java.util.List;

public interface PacienteService {

    public List<Paciente> listar();

    public Paciente buscarPaciente(Long idPaciente);

    public List<Paciente> buscarPorNome(String nome);

    public Paciente salvar(Paciente paciente);

    public Paciente atualizar(Long idPaciente, Paciente pacienteAtualizado);

    public void deletar(Long idPaciente);

}
