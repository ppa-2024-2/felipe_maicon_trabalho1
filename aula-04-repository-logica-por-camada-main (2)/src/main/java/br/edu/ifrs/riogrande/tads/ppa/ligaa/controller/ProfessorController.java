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

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Professor;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.ProfessorService;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.NovoProfessor;
import org.springframework.web.bind.annotation.RequestParam;


// Rotear tudo "que tem a ver" com Professor

@RestController
public class ProfessorController {

    private final ProfessorService professorService;

    // o ProfessorService será "injetado" pelo Spring (framework)
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }
   
    // rotear
    @PostMapping(path = "/api/v1/professores", 
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void novoProfessor(@RequestBody NovoProfessor professor) {

        System.out.println(professor);
        professorService.cadastrarprofessor(professor); // não deve ser IDEMPOTENTE
    }
    
    @GetMapping(path = "/api/v1/professores/{siape}") // identificador
    public ResponseEntity<Professor> buscaSiape(@PathVariable("siape") String siape) {

        Professor professor = professorService.buscarprofessor(siape);

        return ResponseEntity.ok(professor); // 200
    }

    @GetMapping(path = "/api/v1/professores")
    public ResponseEntity<List<Professor>> buscaTodos() {
        return ResponseEntity.ok(professorService.findAll()); // outras opções: 404 ou 204
    }

    // public void novoProfessorV2(NovoProfessorV2 professor)
}
