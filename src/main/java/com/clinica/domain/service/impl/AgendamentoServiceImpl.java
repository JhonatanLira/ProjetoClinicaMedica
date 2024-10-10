package com.clinica.domain.service.impl;

import com.clinica.domain.model.Agendamento;
import com.clinica.domain.repository.AgendamentoRepository;
import com.clinica.domain.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public List<Agendamento> listar() {
        return agendamentoRepository.findAll();
    }

    @Override
    public Agendamento buscaPorId(Long idAgendamento) {
        return agendamentoRepository.findById(idAgendamento).get();
    }

    @Override
    public void salvar(Agendamento agendamento) {
        agendamentoRepository.save(agendamento);
    }

    @Override
    public void atualizar(Long idAgendamento, Agendamento agendamentoAtualizado) {
        if (agendamentoRepository.findById(idAgendamento).isPresent()) {

        }
    }

    @Override
    public void excluir(Long idAgendamento) {

    }
}
