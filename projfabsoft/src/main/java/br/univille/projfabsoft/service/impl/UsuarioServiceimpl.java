package br.univille.projfabsoft.service.impl;

import java.util.List;

import br.univille.projfabsoft.entity.Usuario;
import br.univille.projfabsoft.repository.UsuarioRepository;
import br.univille.projfabsoft.service.UsuarioService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UsuarioServiceimpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario save(Usuario usuario) {
        repository.save(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public Usuario getById(Long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Usuario delete(Long id) {
        var projeto = getById(id);
        if(projeto != null){
            repository.deleteById(id);
        }
        return projeto;
    }

    
}

