package com.alexandre.cursos.repositories;

import com.alexandre.cursos.domain.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alexandre.cursos.domain.Produto;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer>{
@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat where obj.nome LIKE %:nome% AND CAT iN : categorias")
    Page<Produto> search (@Param("nome") String nome, @Param("categorias") List<Categoria>categorias, Pageable pageRequest);
}
