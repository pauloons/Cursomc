package com.alexandre.cursos.services;

import com.alexandre.cursos.domain.Categoria;
import com.alexandre.cursos.domain.Pedido;
import com.alexandre.cursos.domain.Produto;
import com.alexandre.cursos.repositories.CategoriaRepository;
import com.alexandre.cursos.repositories.PedidoRepository;
import com.alexandre.cursos.repositories.ProdutosRepository;
import com.alexandre.cursos.services.exeptions.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutosRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto find(Integer id){
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExeption(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }
    public Page<Produto>search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return repo.search(nome, categorias, pageRequest);
    }
}
