package com.clinica.api.controller;

import com.clinica.domain.model.Medico;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<Medico> listar() {
        return medicoService.listar();
    }

    @GetMapping("/{idMedico}")
    public ResponseEntity<Medico> buscaPorId(@PathVariable Long idMedico) {
        if (medicoRepository.findById(idMedico).isPresent()) {
            return ResponseEntity.ok(medicoService.buscarMedico(idMedico));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Medico> salvar(@RequestBody @Valid Medico medico) {
        medicoService.salvar(medico);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{idMedico}")
    public ResponseEntity<Medico> atualizar(@RequestBody Medico medicoAtualizado, @PathVariable Long idMedico) {
        if (medicoRepository.findById(idMedico).isPresent()) {
            medicoService.atualizar(idMedico, medicoAtualizado);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{idMedico}")
    public ResponseEntity<Medico> excluir(@PathVariable Long idMedico) {
        if (medicoRepository.findById(idMedico).isPresent()) {
            medicoService.deletar(idMedico);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
