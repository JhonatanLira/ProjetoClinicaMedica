package com.clinica.domain.service;

import com.clinica.domain.model.Especialidade;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EspecialidadeService {

    public List<Especialidade> listar();

    public Especialidade buscarPorId(Long idEspecialidade);

    public void salvar(Especialidade especialidade);

    public void atualizar(Long idEspecialidade,Especialidade especialidadeAualizada);

    public void deletar(Long idEspecialidade);

}
