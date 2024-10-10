package com.clinica.domain.service;

import com.clinica.domain.model.Especialidade;
import java.util.List;


public interface EspecialidadeService {

    public List<Especialidade> listar();

    public Especialidade buscarPorId(Long idEspecialidade);

    public void salvar(Especialidade specialty);

    public void atualizar(Long idEspecialidade, Especialidade specialtyAualizada);

    public void excluir(Long idEspecialidade);

}
