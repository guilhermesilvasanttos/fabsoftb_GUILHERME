package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Norma;
import br.univille.projfabsoft.repository.NormaRepository;
import br.univille.projfabsoft.service.NormaService;

@Service
public class NormaServiceimpl implements NormaService{
    
    @Autowired
    private NormaRepository repository;
    
    @Override
    public Norma save(Norma norma) {
        repository.save(norma);
        return norma;
    }
    
    @Override
    public List<Norma> getAll() {
        return repository.findAll();
        }
    
    @Override
        public Norma getById(Long id) {
            var retorno = repository.findById(id);
            if(retorno.isPresent())
                return retorno.get();
            return null;
        }
    
    @Override
    public Norma delete(Long id) {
        var norma = getById(id);
            if(norma != null){
                repository.deleteById(id);
            }
            return norma;
        }
    }