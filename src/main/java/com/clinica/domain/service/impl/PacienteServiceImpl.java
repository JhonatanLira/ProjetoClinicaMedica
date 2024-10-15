package com.clinica.domain.service.impl;

import com.clinica.domain.model.Paciente;
import com.clinica.domain.repository.PacienteRepository;
import com.clinica.domain.service.PacienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente buscarPaciente(Long id) {
        Optional<Paciente> PacienteOptional = pacienteRepository.findById(id);
        return PacienteOptional.get();
    }

    @Override
    public Paciente buscaPacientePorNome(String nome) {
        System.out.println("Service");
        return pacienteRepository.findByNomeContaining(nome);
    }

    @Override
    public void salvar(Paciente paciente) {

        pacienteRepository.save(paciente);
    }

    @Override
    public void atualizar(Long id, Paciente pacienteAtualizado) {
        Paciente paciente = pacienteRepository.findById(id).get();
        BeanUtils.copyProperties(pacienteAtualizado, paciente, "idPaciente");
        salvar(paciente);
    }

    @Override
    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }
}
