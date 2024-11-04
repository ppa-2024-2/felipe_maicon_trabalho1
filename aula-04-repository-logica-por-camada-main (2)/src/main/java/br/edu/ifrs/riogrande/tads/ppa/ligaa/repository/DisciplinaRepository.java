package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Disciplina;

@Repository // infraestrutura
public class DisciplinaRepository implements IRepository<Disciplina> {

    private Map<UUID, Disciplina> mapa = new HashMap<>();

    @Override
    public Disciplina save(Disciplina d) { // a id=f1323, desativado=true

        LocalDateTime agora = LocalDateTime.now();
        
        if (d.getId() == null) { // não é persistente
            d.setDataHoraCriacao(agora);
            d.setId(UUID.randomUUID()); // atribuir um ID
            d.setDesativado(false);
        }
        
        if (d.isDesativado() || (mapa.containsKey(d.getId()) && mapa.get(d.getId()).isDesativado())) {
            throw new EntidadeInativaException();
        }
        
        d.setDataHoraAlteracao(agora);
        
        mapa.put(d.getId(), d);
        
        return d;
    }

    public boolean codigoExists(String codigo) {
        return mapa.values().stream()
            // qualquer um coincide o CPF?
            .anyMatch(disciplina -> codigo.equals(disciplina.getCodigo()));
    }


    @Override
    public boolean delete(Disciplina e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public List<Disciplina> findAll() {
        return new ArrayList<Disciplina>(mapa.values());
    }
}