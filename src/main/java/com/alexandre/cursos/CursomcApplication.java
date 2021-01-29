package com.alexandre.cursos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.cursos.domain.Categoria;
import com.alexandre.cursos.domain.Cidade;
import com.alexandre.cursos.domain.Estado;
import com.alexandre.cursos.domain.Produto;
import com.alexandre.cursos.repositories.CategoriaRepository;
import com.alexandre.cursos.repositories.ProdutosRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
    
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		 Categoria cat1 = new Categoria(null, "Informatica");
		 Categoria cat2 = new Categoria(null, "Escritorio");
	
		 Produto p1 = new Produto(null,"Computador", 2.500); 
		 Produto p2 = new Produto(null,"Impressora", 1.000);
		 Produto p3 = new Produto(null,"Mouse", 50.00);
		 
		 Estado est1 = new Estado(null,"Brasilia");
		 Estado est2 = new Estado(null, "São Paulo");
		 
		 Cidade c1 = new Cidade(null, "Recanto das Emas",est1);
		 Cidade c2 = new Cidade(null, "Andradina",est2);
		
		 
		 cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		 cat1.getProdutos().addAll(Arrays.asList(p2));
		 
		 p1.getCategorias().addAll(Arrays.asList(cat1));
		 p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		 p3.getCategorias().addAll(Arrays.asList(cat1));
		 
		
		 
	
		 categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		 produtosRepository.saveAll(Arrays.asList(p1,p2,p3));

	}
	
	
}
