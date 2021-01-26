package com.alexandre.cursos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.cursos.domain.Categoria;
import com.alexandre.cursos.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
    
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		 Categoria cat1 = new Categoria(null, "tests");
		 Categoria cat2 = new Categoria(null, "Escritorio");
		 List<Categoria> lista = new ArrayList<>();
		 lista.add(cat1);
		 lista.add(cat2);
		 
		 categoriaRepository.saveAll(lista); 

	}
	
	
}
