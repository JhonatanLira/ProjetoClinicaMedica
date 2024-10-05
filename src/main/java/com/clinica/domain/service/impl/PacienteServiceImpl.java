package com.clinica.domain.service.impl;

import com.clinica.domain.model.Patient;
import com.clinica.domain.repository.PatientRepository;
import com.clinica.domain.service.PacienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> listar() {
        return patientRepository.findAll();
    }

    @Override
    public Patient buscarPaciente(Long id) {
        Optional<Patient> PacienteOptional = patientRepository.findById(id);
        return PacienteOptional.get();
    }

    @Override
    public void salvar(Patient paciente) {
      // paciente.setDataCadastro(LocalDate.now());
        patientRepository.save(paciente);
    }

    @Override
    public void atualizar(Long id, Patient pacienteAtualizado) {
        Patient paciente = patientRepository.findById(id).get();
        BeanUtils.copyProperties(pacienteAtualizado, paciente,"idPaciente");
        salvar(paciente);
    }

    @Override
    public void deletar(Long id) {
        patientRepository.deleteById(id);
    }
}
