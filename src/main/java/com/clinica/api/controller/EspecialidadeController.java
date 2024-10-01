package com.clinica.api.controller;

import com.clinica.domain.model.Especialidade;
import com.clinica.domain.repository.EspecialidadeRepository;
import com.clinica.domain.service.EspecialidadeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CRUD Especialidade*", description = "Registra as especialidade dos Médicos")
@Controller
@RequestMapping("/especialidades")
public class EspecialidadeController {

    private EspecialidadeService especialidadeService;

    public EspecialidadeController(EspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    private EspecialidadeRepository especialidadeRepository;

    public EspecialidadeController(EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    @GetMapping
    public List<Especialidade> list() {
        return especialidadeService.listar();
    }

    @GetMapping("/{idEspecialidade}")
    public List<Especialidade> findById(@PathVariable Long idEpecialidade) {
        if(especialidadeRepository.findById().isPresent()) {
            return ResponseEntity.ok(especialidadeService.buscarPorId(idEpecialidade));
        }
    }

    @PostMapping()
    public ResponseEntity<Especialidade> save(@RequestBody @Valid Especialidade especialidade) {
        if (especialidade != null) {
            especialidadeService.salvar(especialidade);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.notFound().build();
    }

}
