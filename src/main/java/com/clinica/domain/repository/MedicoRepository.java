package com.clinica.domain.repository;

import com.clinica.domain.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
