package com.clinica.domain.repository;

import com.clinica.domain.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Scheduling, Long> {
}
