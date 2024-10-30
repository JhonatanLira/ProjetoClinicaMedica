package com.clinica.api.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.clinica.domain.dtos.PacienteDto;
import com.clinica.domain.model.Paciente;
import com.clinica.domain.repository.PacienteRepository;
import com.clinica.domain.service.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "PACIENTE", description = "CRUD Paciente")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/")
    public List<Paciente> listar() {
        return pacienteService.listar();
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid PacienteDto pacienteDto) {
        var paciente = new Paciente();
        BeanUtils.copyProperties(pacienteDto, paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.salvar(paciente));
    }

    @PutMapping("/{idPaciente}")
    public ResponseEntity<Object> atualizar(@RequestBody PacienteDto pacienteDto, @Valid @PathVariable Long idPaciente) {

        if (!pacienteRepository.existsById(idPaciente)) {
            return ResponseEntity.notFound().build();
        }
        var paciente = new Paciente();
        BeanUtils.copyProperties(pacienteDto, paciente);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.atualizar(idPaciente, paciente));
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long idPaciente) {
        if (!pacienteRepository.existsById(idPaciente)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.buscarPacientePorId(idPaciente));
    }

    @DeleteMapping("/{idPaciente}")
    public ResponseEntity<Paciente> excluir(@PathVariable Long idPaciente) {
        if (!pacienteRepository.existsById(idPaciente)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
