package com.clinica.domain.repository;

import com.clinica.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    //public List<Paciente> findByNomeContaining(String nome);

    public Paciente findByNomeContaining(String nome);
}
