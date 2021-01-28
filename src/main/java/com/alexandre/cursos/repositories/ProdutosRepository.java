package com.alexandre.cursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexandre.cursos.domain.Produto;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer>{


}
