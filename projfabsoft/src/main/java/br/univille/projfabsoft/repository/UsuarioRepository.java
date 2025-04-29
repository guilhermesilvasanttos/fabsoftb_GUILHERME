package br.univille.projfabsoft.repository;
import br.univille.projfabsoft.entity.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository  
    extends JpaRepository<Usuario,Long> {
    
}
