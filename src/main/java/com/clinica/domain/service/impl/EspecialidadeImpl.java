package com.clinica.domain.service.impl;

import com.clinica.domain.model.Especialidade;
import com.clinica.domain.repository.EspecialidadeRepository;
import com.clinica.domain.service.EspecialidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeImpl implements EspecialidadeService {

    private EspecialidadeRepository especialidadeRepository;

    public EspecialidadeImpl(EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    @Override
    public List<Especialidade> listar() {
        return especialidadeRepository.findAll();
    }

    @Override
    public Especialidade buscarPorId(Long idEspecialidade) {
        return especialidadeRepository.findById(idEspecialidade).get();
    }

    @Override
    public void salvar(Especialidade especialidade) {
        especialidadeRepository.save(especialidade);
    }

    @Override
    public void atualizar(Long idEspecialidade, Especialidade especialidadeAualizada) {

        if (especialidadeRepository.findById(idEspecialidade).isPresent()) {
            Especialidade especialidade = especialidadeRepository.findById(idEspecialidade).get();
            BeanUtils.copyProperties(especialidadeAualizada, especialidade, "idEspecialidade");
            salvar(especialidade);
        }
    }

    @Override
    public void deletar(Long idEspecialidade) {
        if(especialidadeRepository.findById(idEspecialidade).isPresent()){
            especialidadeRepository.deleteById(idEspecialidade);
        }
    }
}
