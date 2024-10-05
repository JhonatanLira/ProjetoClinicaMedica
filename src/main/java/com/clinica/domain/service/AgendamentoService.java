package com.clinica.domain.service;

import com.clinica.domain.model.Scheduling;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgendamentoService {

    public List<Scheduling> Listar();

    public Scheduling buscaPorId(Long idAgendamento);

    public void salvar(Scheduling agendamento);

    public void Atualizar(Long idAgendamento, Scheduling agendamentoAtualizado);

    public void excluir(Long idAgendamento);
}
