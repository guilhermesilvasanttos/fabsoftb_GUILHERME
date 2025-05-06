package br.univille.projfabsoft.service;
import br.univille.projfabsoft.entity.Usuario;
import br.univille.projfabsoft.service.UsuarioService;
import java.util.List;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    List<Usuario> getAll();
    Usuario getById(Long id);
    Usuario delete(Long id);
}