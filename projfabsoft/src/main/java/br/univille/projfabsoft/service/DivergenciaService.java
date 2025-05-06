package br.univille.projfabsoft.service;
import java.util.List;
import br.univille.projfabsoft.entity.Divergencia;


public interface DivergenciaService {
    Divergencia save(Divergencia divergencia);
    List<Divergencia> getAll();
    Divergencia getById(Long id);
    Divergencia delete(Long id);

}

