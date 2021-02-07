package com.alexandre.cursos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.cursos.domain.Categoria;
import com.alexandre.cursos.domain.Cidade;
import com.alexandre.cursos.domain.Cliente;
import com.alexandre.cursos.domain.Endereco;
import com.alexandre.cursos.domain.Estado;
import com.alexandre.cursos.domain.Produto;
import com.alexandre.cursos.domain.enums.Tipo_Cliente;
import com.alexandre.cursos.repositories.CategoriaRepository;
import com.alexandre.cursos.repositories.CidadeRepository;
import com.alexandre.cursos.repositories.ClienteRepository;
import com.alexandre.cursos.repositories.EnderecoRepository;
import com.alexandre.cursos.repositories.EstadoRepository;
import com.alexandre.cursos.repositories.ProdutosRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutosRepository produtosRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null, "Computador", 2.500);
		Produto p2 = new Produto(null, "Impressora", 1.000);
		Produto p3 = new Produto(null, "Mouse", 50.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtosRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Brasilia");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Campinas", est1);
		Cidade c2 = new Cidade(null, "Andradina", est2);
		Cidade c3 = new Cidade(null, "Guarujá", est2);
		Cidade c4 = new Cidade(null, "Recanto", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		Cliente cli1 = new Cliente(null, "Paulo", "pauloons@gmail.com", "0238050923", Tipo_Cliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "Thamyres", "thamyres@gmail.com", "017657745", Tipo_Cliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("981019380", "34346067"));
		cli2.getTelefones().addAll(Arrays.asList("984554845", "33545564"));

		Endereco e1 = new Endereco(null, "logadouro", "10", "Na rua do Frango", "Recanto das Emas", "72640206", c4,cli2);
		Endereco e2 = new Endereco(null, "logadouro", "255", "Proximo ao primor", "Samambaia", "7254778", c4, cli1);

		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli1.getEnderecos().addAll(Arrays.asList(e2));

		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}
}