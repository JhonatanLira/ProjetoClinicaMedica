package com.clinica.api.controller;

import com.clinica.domain.model.Doctor;
import com.clinica.domain.repository.MedicoRepository;
import com.clinica.domain.service.MedicoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "MÉDICO", description = "CRUD Médico")
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public List<Doctor> listar() {
        return medicoService.listar();
    }

    @GetMapping("/{idMedico}")
    public ResponseEntity<Doctor> buscaPorId(@PathVariable Long idMedico) {
        if (medicoRepository.findById(idMedico).isPresent()) {
            return ResponseEntity.ok(medicoService.buscarMedico(idMedico));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Doctor> salvar(@RequestBody @Valid Doctor doctor) {
        medicoService.salvar(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{idMedico}")
    public ResponseEntity<Doctor> atualizar(@RequestBody Doctor doctorAtualizado, @PathVariable Long idMedico) {
        if (medicoRepository.findById(idMedico).isPresent()) {
            medicoService.atualizar(idMedico, doctorAtualizado);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{idMedico}")
    public ResponseEntity<Doctor> excluir(@PathVariable Long idMedico) {
        if (medicoRepository.findById(idMedico).isPresent()) {
            medicoService.deletar(idMedico);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
