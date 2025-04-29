package br.univille.projfabsoft.service;
import br.univille.projfabsoft.service.ItemavaliacaoService;
import java.util.List;

public interface ItemavaliacaoService {
    Itemavaliacao save(Itemavaliacao projeto);
    List<Itemavaliacao> getAll();
    Itemavaliacao getById(Long id);
    Itemavaliacao delete(Long id);
    
}