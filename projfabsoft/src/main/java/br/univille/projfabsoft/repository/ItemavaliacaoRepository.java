package br.univille.projfabsoft.repository;
import br.univille.projfabsoft.repository.ItemavaliacaoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemavaliacaoRepository  
    extends JpaRepository<Itemavalicao,Long> {
    
}