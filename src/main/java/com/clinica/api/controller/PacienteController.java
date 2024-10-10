package com.clinica.api.controller;

import com.clinica.domain.model.Paciente;
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
    public List<Paciente> listar() {
        return pacienteService.listar();
    }

    @PostMapping
    public ResponseEntity<Paciente> salvar(@RequestBody @Valid Paciente paciente) {
        if (paciente != null) {
            pacienteService.salvar(paciente);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<Paciente> buscaPorId(@PathVariable Long idPaciente) {
        if (patientRepository.findById(idPaciente).isPresent()) {
            return ResponseEntity.ok(pacienteService.buscarPaciente(idPaciente));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{idPaciente}")
    public ResponseEntity<Paciente> atualizar(@PathVariable Long idPaciente, @RequestBody Paciente pacienteAtualizado) {

        if (patientRepository.findById(idPaciente).isPresent()) {
            pacienteService.atualizar(idPaciente, pacienteAtualizado);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idPaciente}")
    public ResponseEntity<Paciente> deletar(@PathVariable Long idPaciente) {
        if (patientRepository.findById(idPaciente).isPresent()) {
            pacienteService.deletar(idPaciente);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
