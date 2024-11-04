package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;
// new professorService()

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Professor;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorRepository;

@Service // qualificando o objeto
public class ProfessorService {

    // dependência
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void cadastrarprofessor(NovoProfessor novoprofessor) {

        if (professorRepository.siapeExists(novoprofessor.getSiape())) {
            throw new IllegalStateException("SIAPE já existe: " + novoprofessor.getSiape());
        }

        // ONDE FICAM AS REGRAS DE DOMÍNIO
        Professor professor = new Professor();

        professor.setSiape(novoprofessor.getSiape());
        professor.setNome(novoprofessor.getNome());
        professor.setFormacao(novoprofessor.getFormacao());

        professorRepository.save(professor);        
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor buscarprofessor(@NonNull String cpf) {
        return new Professor();
    }
 
}
