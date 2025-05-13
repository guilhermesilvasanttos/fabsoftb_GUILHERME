package br.univille.projfabsoft.service;
import br.univille.projfabsoft.entity.ItemAvaliacao;
import java.util.List;

public interface ItemavaliacaoService {
    ItemAvaliacao save(ItemAvaliacao itemavaliacao);
    List<ItemAvaliacao> getAll();
    ItemAvaliacao getById(Long id);
    ItemAvaliacao delete(Long id);

}