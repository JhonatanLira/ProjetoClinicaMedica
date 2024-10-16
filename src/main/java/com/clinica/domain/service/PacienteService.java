package com.clinica.domain.service;

import com.clinica.domain.model.Paciente;

import java.util.List;

public interface PacienteService {

    public List<Paciente> listar();

    public Paciente buscarPaciente(Long id);

   // public List<Paciente> buscaPacientePorNome(String nome);
   public Paciente buscaPacientePorNome(String nome);

    public void salvar(Paciente paciente);

    public void atualizar(Long id, Paciente paciente);

    public void deletar(Long id);

}
