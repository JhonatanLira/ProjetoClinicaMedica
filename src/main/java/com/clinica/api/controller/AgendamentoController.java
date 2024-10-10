package com.clinica.api.controller;

import com.clinica.domain.model.Agendamento;
import com.clinica.domain.service.impl.AgendamentoServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CRUD Agendamento")
@RestController
@RequestMapping(name = "agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoServiceImpl agendamentoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<Agendamento> listar() {
        return agendamentoService.listar();
    }

    @PostMapping
    public ResponseEntity<Agendamento> salvar(@RequestBody @Valid Agendamento agendamento) {
        if (agendamento == null) {
            return ResponseEntity.notFound().build();
        }
        agendamentoService.salvar(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{idAgendamento}")
    public ResponseEntity<Agendamento> buscaPorId(@PathVariable Long idAgendamento) {
        if (agendamentoService.buscaPorId(idAgendamento) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agendamentoService.buscaPorId(idAgendamento));
    }

    @PutMapping("/{idAgendamento}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Long idAgendamento, Agendamento agendamentoAtualizado) {
        if (agendamentoService.buscaPorId(idAgendamento) == null) {
            return ResponseEntity.notFound().build();
        }
        agendamentoService.atualizar(idAgendamento, agendamentoAtualizado);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idAgendamento}")
    public ResponseEntity<Agendamento> deletar(@PathVariable Long idAgendamento) {
        if (agendamentoService.buscaPorId(idAgendamento) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        agendamentoService.excluir(idAgendamento);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
