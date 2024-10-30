package com.clinica.domain.service.impl;

import com.clinica.domain.model.Paciente;
import com.clinica.domain.repository.PacienteRepository;
import com.clinica.domain.service.PacienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;


    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente buscarPacientePorId(Long idPaciente) {
        return pacienteRepository.findById(idPaciente).get();
    }

    @Override
    public List<Paciente> buscarPorNome(String nome) {
        return null;
    }
    @Transactional
    @Override
    public Paciente salvar(Paciente paciente) {
        paciente.setDocumento(paciente.getDocumento().replace(".","").replace("-",""));
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente atualizar(Long idPaciente, Paciente pacienteAtualizado) {

        pacienteAtualizado.setIdPaciente(idPaciente);

        return salvar(pacienteAtualizado);
    }

    @Override
    public void deletar(Long idPaciente) {
       pacienteRepository.deleteById(idPaciente);
    }
}
