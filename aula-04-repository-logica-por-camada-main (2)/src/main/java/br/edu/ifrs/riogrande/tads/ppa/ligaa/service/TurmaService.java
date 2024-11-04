package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;
// new turmaService()

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Turma;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.TurmaRepository;

@Service // qualificando o objeto
public class TurmaService {

    // dependência
    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public void cadastrarturma(NovoTurma novoturma) {
        // ONDE FICAM AS REGRAS DE DOMÍNIO
        Turma turma = new Turma();

        //turma.setCodigo(novoturma.getCodigo());
        //turma.setNome(novoturma.getNome());
        //turma.setCargaHoraria(novoturma.getCargaHoraria());

        turmaRepository.save(turma);        
    }

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }
}