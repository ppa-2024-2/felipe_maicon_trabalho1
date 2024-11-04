package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Turma;

@Repository // infraestrutura
public class TurmaRepository implements IRepository<Turma> {

    private Map<UUID, Turma> mapa = new HashMap<>();

    @Override
    public Turma save(Turma t) { // a id=f1323, desativado=true

        LocalDateTime agora = LocalDateTime.now();
        
        if (t.getId() == null) { // não é persistente
            t.setDataHoraCriacao(agora);
            t.setId(UUID.randomUUID()); // atribuir um ID
            t.setDesativado(false);
        }
        
        if (t.isDesativado() || (mapa.containsKey(t.getId()) && mapa.get(t.getId()).isDesativado())) {
            throw new EntidadeInativaException();
        }
        
        t.setDataHoraAlteracao(agora);
        
        mapa.put(t.getId(), t);
        
        return t;
    }

    @Override
    public boolean delete(Turma e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public List<Turma> findAll() {
        return new ArrayList<Turma>(mapa.values());
    }
}