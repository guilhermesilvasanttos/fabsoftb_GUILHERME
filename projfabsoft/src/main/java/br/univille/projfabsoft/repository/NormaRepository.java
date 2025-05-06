package br.univille.projfabsoft.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoft.entity.Norma;

@Repository
public interface NormaRepository  
    extends JpaRepository<Norma,Long> { 
}