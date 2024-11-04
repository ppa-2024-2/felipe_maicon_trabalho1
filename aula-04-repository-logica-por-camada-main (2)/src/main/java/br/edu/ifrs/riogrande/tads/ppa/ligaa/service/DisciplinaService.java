package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;
// new disciplinaService()

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Disciplina;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.DisciplinaRepository;

@Service // qualificando o objeto
public class DisciplinaService {

    // dependência
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public void cadastrardisciplina(NovoDisciplina novodisciplina) {

        if (disciplinaRepository.codigoExists(novodisciplina.getCodigo())) {
            throw new IllegalStateException("Código já existe: " + novodisciplina.getCodigo());
        }

        // ONDE FICAM AS REGRAS DE DOMÍNIO
        Disciplina disciplina = new Disciplina();

        disciplina.setCodigo(novodisciplina.getCodigo());
        disciplina.setNome(novodisciplina.getNome());
        disciplina.setCargaHoraria(novodisciplina.getCargaHoraria());

        disciplinaRepository.save(disciplina);        
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public Disciplina buscardisciplina(@NonNull String codigo) {
        return new Disciplina();
    }
 
}
