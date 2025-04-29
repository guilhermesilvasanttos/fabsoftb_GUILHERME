package br.univille.projfabsoft.service;
import java.util.List;
import br.univille.projfabsoft.entity.Documento;

public interface DocumentoService {
    Documento save(Documento documento);
    List<Documento> getAll();
    Documento getById(Long id);
    Documento delete(Long id);
    
}

