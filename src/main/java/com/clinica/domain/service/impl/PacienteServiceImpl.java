package com.clinica.domain.service.impl;

import com.clinica.domain.model.Paciente;
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
    public List<Paciente> listar() {
        return patientRepository.findAll();
    }

    @Override
    public Paciente buscarPaciente(Long id) {
        Optional<Paciente> PacienteOptional = patientRepository.findById(id);
        return PacienteOptional.get();
    }

    @Override
    public void salvar(Paciente paciente) {
      // paciente.setDataCadastro(LocalDate.now());
        patientRepository.save(paciente);
    }

    @Override
    public void atualizar(Long id, Paciente pacienteAtualizado) {
        Paciente paciente = patientRepository.findById(id).get();
        BeanUtils.copyProperties(pacienteAtualizado, paciente,"idPaciente");
        salvar(paciente);
    }

    @Override
    public void deletar(Long id) {
        patientRepository.deleteById(id);
    }
}
