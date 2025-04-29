package br.univille.projfabsoft.service;
import br.univille.projfabsoft.entity.ItemAvaliacao;
import br.univille.projfabsoft.service.ItemavaliacaoService;
import java.util.List;

public interface ItemavaliacaoService {
    ItemAvaliacao save(ItemAvaliacao projeto);
    List<ItemAvaliacao> getAll();
    ItemAvaliacao getById(Long id);
    ItemAvaliacao delete(Long id);

    
}