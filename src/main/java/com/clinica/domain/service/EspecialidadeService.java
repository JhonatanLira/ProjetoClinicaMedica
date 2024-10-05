package com.clinica.domain.service;

import com.clinica.domain.model.Specialty;

import java.util.List;


public interface EspecialidadeService {

    public List<Specialty> listar();

    public Specialty buscarPorId(Long idEspecialidade);

    public void salvar(Specialty specialty);

    public void atualizar(Long idEspecialidade, Specialty specialtyAualizada);

    public void excluir(Long idEspecialidade);

}
