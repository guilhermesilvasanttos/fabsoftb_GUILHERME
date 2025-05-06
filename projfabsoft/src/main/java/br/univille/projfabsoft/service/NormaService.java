package br.univille.projfabsoft.service;
import br.univille.projfabsoft.entity.Norma;
import br.univille.projfabsoft.service.NormaService;
import java.util.List;

public interface NormaService {
    Norma save(Norma norma);
    List<Norma> getAll();
    Norma getById(Long id);
    Norma delete(Long id);

    
}