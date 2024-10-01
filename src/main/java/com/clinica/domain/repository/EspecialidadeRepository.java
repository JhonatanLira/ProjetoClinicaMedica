package com.clinica.domain.repository;

import com.clinica.domain.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository  extends JpaRepository<Especialidade, Long> {
}