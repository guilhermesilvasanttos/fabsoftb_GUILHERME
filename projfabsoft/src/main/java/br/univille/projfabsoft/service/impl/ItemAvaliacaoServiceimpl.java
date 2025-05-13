package br.univille.projfabsoft.service.impl;

import java.util.List;
import br.univille.projfabsoft.repository.ItemavaliacaoRepository;
import br.univille.projfabsoft.entity.ItemAvaliacao;
import br.univille.projfabsoft.service.ItemavaliacaoService;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ItemAvaliacaoServiceImpl implements ItemavaliacaoService {

    @Autowired
    private ItemavaliacaoRepository repository;

    @Override
    public ItemAvaliacao save(ItemAvaliacao itemavaliacao) {
        repository.save(itemavaliacao);
        return itemavaliacao;
    }

    @Override
    public List<ItemAvaliacao> getAll() {
        return repository.findAll();
    }

    @Override
    public ItemAvaliacao getById(Long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public ItemAvaliacao delete(Long id) {
        var itemavaliacao = getById(id);
        if(itemavaliacao != null){
            repository.deleteById(id);
        }
        return itemavaliacao;
    }

}

//aa

