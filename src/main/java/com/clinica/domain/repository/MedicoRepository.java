package com.clinica.domain.repository;

import com.clinica.domain.model.Medico;
import org.springframework.data.repository.CrudRepository;

public interface MedicoRepository extends CrudRepository<Medico, Long> {
}
