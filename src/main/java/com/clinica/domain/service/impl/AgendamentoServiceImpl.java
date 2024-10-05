package com.clinica.domain.service.impl;

import com.clinica.domain.model.Scheduling;
import com.clinica.domain.repository.AgendamentoRepository;
import com.clinica.domain.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;


    @Override
    public List<Scheduling> Listar() {
        return agendamentoRepository.findAll();
    }

    @Override
    public Scheduling buscaPorId(Long idAgendamento) {
        return agendamentoRepository.findById(idAgendamento).get();
    }

    @Override
    public void salvar(Scheduling agendamento) {
        agendamentoRepository.save(agendamento);
    }

    @Override
    public void Atualizar(Long idAgendamento, Scheduling agendamentoAtualizado) {
        if (agendamentoRepository.findById(idAgendamento).isPresent()) {

        }
    }

    @Override
    public void excluir(Long idAgendamento) {

    }
}
