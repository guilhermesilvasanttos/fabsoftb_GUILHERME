package br.univille.projfabsoft.service.impl;

import java.util.List;
import br.univille.projfabsoft.repository.DocumentoRepository;
import br.univille.projfabsoft.entity.Documento;
import br.univille.projfabsoft.service.DocumentoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class DocumentoServiceimpl implements DocumentoService {

    @Autowired
    private DocumentoRepository repository;

    @Override
    public Documento save(Documento documento) {
        repository.save(documento);
        return documento;
    }

    @Override
    public List<Documento> getAll() {
        return repository.findAll();
    }

    @Override
    public Documento getById(Long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Documento delete(Long id) {
        var documento = getById(id);
        if(documento != null){
            repository.deleteById(id);
        }
        return documento;
    }
}

