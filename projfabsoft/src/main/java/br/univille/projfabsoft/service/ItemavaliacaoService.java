package br.univille.projfabsoft.service;
import br.univille.projfabsoft.entity.ItemAvaliacao;
import br.univille.projfabsoft.service.ItemAvaliacaoService;
import java.util.List;

public interface ItemAvaliacaoService {
    ItemAvaliacao save(ItemAvaliacao itemavaliacao);
    List<ItemAvaliacao> getAll();
    ItemAvaliacao getById(Long id);
    ItemAvaliacao delete(Long id);

    
}