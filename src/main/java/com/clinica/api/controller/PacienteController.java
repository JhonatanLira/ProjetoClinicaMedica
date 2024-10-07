package com.clinica.api.controller;

import com.clinica.domain.model.Patient;
import com.clinica.domain.repository.PatientRepository;
import com.clinica.domain.service.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "PACIENTE", description = "CRUD Paciente")
//@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/")
    public List<Patient> listar() {
        return pacienteService.listar();
    }

    @PostMapping
    public ResponseEntity<Patient> salvar(@RequestBody @Valid Patient paciente) {
        if (paciente != null) {
            pacienteService.salvar(paciente);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<Patient> buscaPorId(@PathVariable Long idPaciente) {
        if (patientRepository.findById(idPaciente).isPresent()) {
            return ResponseEntity.ok(pacienteService.buscarPaciente(idPaciente));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{idPaciente}")
    public ResponseEntity<Patient> atualizar(@PathVariable Long idPaciente, @RequestBody Patient pacienteAtualizado) {

        if (patientRepository.findById(idPaciente).isPresent()) {
            pacienteService.atualizar(idPaciente, pacienteAtualizado);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idPaciente}")
    public ResponseEntity<Patient> deletar(@PathVariable Long idPaciente) {
        if (patientRepository.findById(idPaciente).isPresent()) {
            pacienteService.deletar(idPaciente);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
