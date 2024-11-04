package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Professor;

@Repository // infraestrutura
public class ProfessorRepository implements IRepository<Professor> {

    private Map<UUID, Professor> mapa = new HashMap<>();

    @Override
    public Professor save(Professor p) { // a id=f1323, desativado=true

        LocalDateTime agora = LocalDateTime.now();
        
        if (p.getId() == null) { // não é persistente
            p.setDataHoraCriacao(agora);
            p.setId(UUID.randomUUID()); // atribuir um ID
            p.setDesativado(false);
        }
        
        if (p.isDesativado() || (mapa.containsKey(p.getId()) && mapa.get(p.getId()).isDesativado())) {
            throw new EntidadeInativaException();
        }
        
        p.setDataHoraAlteracao(agora);
        
        mapa.put(p.getId(), p);
        
        return p;
    }

    public boolean siapeExists(String siape) {
        return mapa.values().stream()
            // qualquer um coincide o CPF?
            .anyMatch(professor -> siape.equals(professor.getSiape()));
    }


    @Override
    public boolean delete(Professor e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public List<Professor> findAll() {
        return new ArrayList<Professor>(mapa.values());
    }
}