package com.clinica.domain.service;

import com.clinica.domain.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicoService {

    public List<Doctor> listar();

    public Doctor buscarMedico(Long idMedico);

    public void salvar(Doctor doctor);

    public void atualizar(Long idMedico, Doctor doctorAtualizado);

    public void deletar(Long idMedico);

}
