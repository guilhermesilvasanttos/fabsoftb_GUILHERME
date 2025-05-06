package br.univille.projfabsoft.service.impl;

import java.util.List;

import br.univille.projfabsoft.repository.DivergenciaRepository;
import br.univille.projfabsoft.service.DivergenciaService;
import br.univille.projfabsoft.entity.Divergencia;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class DivergenciaServiceimpl implements DivergenciaService{

    @Autowired
    private DivergenciaRepository repository;

    @Override
    public Divergencia save(Divergencia Divergencia) {
        repository.save(Divergencia);
        return Divergencia;
    }

    @Override
    public List<Divergencia> getAll() {
        return repository.findAll();
    }

    @Override
    public Divergencia getById(Long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Divergencia delete(Long id) {
        var Divergencia = getById(id);
        if(Divergencia != null){
            repository.deleteById(id);
        }
        return Divergencia;
    }

}

