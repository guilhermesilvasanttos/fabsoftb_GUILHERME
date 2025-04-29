package br.univille.projfabsoft.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoft.entity.Divergencia;

@Repository
public interface DivergenciaRepository  
    extends JpaRepository<Divergencia,Long> {
    
}

