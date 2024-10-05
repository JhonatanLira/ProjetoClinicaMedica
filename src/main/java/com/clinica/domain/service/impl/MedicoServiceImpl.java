package com.clinica.domain.service.impl;

import com.clinica.domain.model.Doctor;

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
    public List<Doctor> listar() {
        return medicoRepository.findAll();
    }

    @Override
    public Doctor buscarMedico(Long idMedico) {
        return medicoRepository.findById(idMedico).get();
    }

    @Override
    public void salvar(Doctor doctor) {
        medicoRepository.save(doctor);
    }

    @Override
    public void atualizar(Long idMedico, Doctor doctorAtualizado) {
        Doctor doctor = medicoRepository.findById(idMedico).get();
        BeanUtils.copyProperties(doctorAtualizado, doctor,"idMedico");
        salvar(doctor);
    }

    @Override
    public void deletar(Long idMedico) {
        medicoRepository.deleteById(idMedico);
    }
}
