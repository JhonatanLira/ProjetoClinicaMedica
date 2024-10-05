package com.clinica.domain.service;

import com.clinica.domain.model.Patient;

import java.util.List;

public interface PacienteService {

    public List<Patient> listar();

    public Patient buscarPaciente(Long id);

    public void salvar(Patient paciente);

    public void atualizar(Long id, Patient paciente);

    public void deletar(Long id);

}
