package com.clinica.domain.service.impl;

import com.clinica.domain.model.Medico;

import com.clinica.domain.repository.MedicoRepository;
import com.clinica.domain.service.MedicoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico buscarMedico(Long idMedico) {
        return medicoRepository.findById(idMedico).get();
    }

    @Override
    public void salvar(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public void atualizar(Long idMedico, Medico medicoAtualizado) {
        Medico medico = medicoRepository.findById(idMedico).get();
        BeanUtils.copyProperties(medicoAtualizado, medico,"idMedico");
        salvar(medico);
    }

    @Override
    public void deletar(Long idMedico) {
        medicoRepository.deleteById(idMedico);
    }
}
