package com.clinica.domain.service;

import com.clinica.domain.model.Medico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicoService {

    public List<Medico> listar();

    public Medico buscarPaciente(Long idMedico);

    public void salvar(Medico medico);

    public void atualizar(Long id, Medico medico);

    public void deletar(Long idMedico);

}
