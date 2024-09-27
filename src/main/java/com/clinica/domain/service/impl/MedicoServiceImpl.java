package com.clinica.domain.service.impl;

import com.clinica.domain.model.Medico;
import com.clinica.domain.repository.MedicoRepository;
import com.clinica.domain.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;


    @Override
    public List<Medico> listar() {
        return List.of();
    }

    @Override
    public Medico buscarPaciente(Long idMedico) {
        return null;
    }

    @Override
    public void salvar(Medico medico) {

    }

    @Override
    public void atualizar(Long id, Medico medico) {

    }

    @Override
    public void deletar(Long idMedico) {

    }
}
