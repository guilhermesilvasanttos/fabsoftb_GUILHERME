package br.univille.projfabsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.univille.projfabsoft.entity.Projeto;


@Repository
public interface ProjetoRepository  
    extends JpaRepository<Projeto,Long> {
    
}


