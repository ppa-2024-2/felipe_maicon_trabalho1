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

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Disciplina;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.DisciplinaService;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.NovoDisciplina;
import org.springframework.web.bind.annotation.RequestParam;


// Rotear tudo "que tem a ver" com Disciplina

@RestController
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    // o DisciplinaService será "injetado" pelo Spring (framework)
    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }
   
    // rotear
    @PostMapping(path = "/api/v1/disciplinas", 
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void novoDisciplina(@RequestBody NovoDisciplina disciplina) {

        System.out.println(disciplina);
        disciplinaService.cadastrardisciplina(disciplina); // não deve ser IDEMPOTENTE
    }
    
    @GetMapping(path = "/api/v1/disciplinas/{siape}") // identificador
    public ResponseEntity<Disciplina> buscaSiape(@PathVariable("siape") String siape) {

        Disciplina disciplina = disciplinaService.buscardisciplina(siape);

        return ResponseEntity.ok(disciplina); // 200
    }

    @GetMapping(path = "/api/v1/disciplinas")
    public ResponseEntity<List<Disciplina>> buscaTodos() {
        return ResponseEntity.ok(disciplinaService.findAll()); // outras opções: 404 ou 204
    }

    // public void novoDisciplinaV2(NovoDisciplinaV2 disciplina)
}
