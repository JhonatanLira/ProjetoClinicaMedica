package com.clinica.domain.service;

import com.clinica.domain.model.Agendamento;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AgendamentoService {

    public List<Agendamento> listar();

    public Agendamento buscaPorId(Long idAgendamento);

    public void salvar(Agendamento agendamento);

    public void atualizar(Long idAgendamento, Agendamento agendamentoAtualizado);

    public void excluir(Long idAgendamento);
}
