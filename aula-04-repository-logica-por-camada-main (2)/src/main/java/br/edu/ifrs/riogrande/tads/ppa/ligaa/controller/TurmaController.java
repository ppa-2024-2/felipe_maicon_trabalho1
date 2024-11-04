package br.edu.ifrs.riogrande.tads.ppa.ligaa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Turma;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.TurmaService;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.NovoTurma;
import org.springframework.web.bind.annotation.RequestParam;


// Rotear tudo "que tem a ver" com Turma

@RestController
public class TurmaController {

    private final TurmaService turmaService;

    // o TurmaService será "injetado" pelo Spring (framework)
    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }
   
    // rotear
    @PostMapping(path = "/api/v1/turmas", 
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void novoTurma(@RequestBody NovoTurma turma) {

        System.out.println(turma);
        turmaService.cadastrarturma(turma); // não deve ser IDEMPOTENTE
    }

    @GetMapping(path = "/api/v1/turmas")
    public ResponseEntity<List<Turma>> buscaTodos() {
        return ResponseEntity.ok(turmaService.findAll()); // outras opções: 404 ou 204
    }

    // public void novoTurmaV2(NovoTurmaV2 turma)
}
