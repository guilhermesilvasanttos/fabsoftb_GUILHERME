package br.univille.projfabsoft.repository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoft.entity.Documento;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface DocumentoRepository  
    extends JpaRepository<Documento,Long> {
    
}
