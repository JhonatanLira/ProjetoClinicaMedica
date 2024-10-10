package com.clinica.api.controller;

import com.clinica.domain.model.Especialidade;
import com.clinica.domain.repository.EspecialidadeRepository;
import com.clinica.domain.service.EspecialidadeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "ESPECIALIDADE", description = "Registra as especialidade dos Médicos")
@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;
    @Autowired
    private EspecialidadeRepository especialidadeRepository;


    @GetMapping("/")
    public List<Especialidade> list() {
        return especialidadeService.listar();
    }

    @GetMapping("/{idEspecialidade}")
    public ResponseEntity<Especialidade> buscaPorId(@PathVariable Long idEspecialidade) {
        if (especialidadeRepository.findById(idEspecialidade).isPresent()) {
            return ResponseEntity.ok(especialidadeService.buscarPorId(idEspecialidade));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping()
    public ResponseEntity<Especialidade> save(@RequestBody @Valid Especialidade specialty) {
        if (specialty != null) {
            especialidadeService.salvar(specialty);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idEspecialidade}")
    public ResponseEntity<Especialidade> update(@PathVariable Long idEspecialidade, @RequestBody @Valid Especialidade especialidadeAtualizada) {

        if (especialidadeRepository.findById(idEspecialidade).isPresent()) {
            especialidadeService.atualizar(idEspecialidade, especialidadeAtualizada);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idEspecialidade}")
    public ResponseEntity<Especialidade> delete(@PathVariable Long idEspecialidade) {
        if (especialidadeRepository.findById(idEspecialidade).isPresent()) {
            especialidadeService.excluir(idEspecialidade);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
