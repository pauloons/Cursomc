package com.alexandre.cursos;

import java.text.SimpleDateFormat;
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
import com.alexandre.cursos.domain.ItemPedido;
import com.alexandre.cursos.domain.Pagamento;
import com.alexandre.cursos.domain.Pagamento_Com_Boleto;
import com.alexandre.cursos.domain.Pagamento_Com_Cartao;
import com.alexandre.cursos.domain.Pedido;
import com.alexandre.cursos.domain.Produto;
import com.alexandre.cursos.domain.enums.Estado_Pagamento;
import com.alexandre.cursos.domain.enums.Tipo_Cliente;
import com.alexandre.cursos.repositories.CategoriaRepository;
import com.alexandre.cursos.repositories.CidadeRepository;
import com.alexandre.cursos.repositories.ClienteRepository;
import com.alexandre.cursos.repositories.EnderecoRepository;
import com.alexandre.cursos.repositories.EstadoRepository;
import com.alexandre.cursos.repositories.ItemPedidoRepository;
import com.alexandre.cursos.repositories.PagamentoRepository;
import com.alexandre.cursos.repositories.PedidoRepository;
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

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Açougue");
		Categoria cat4 = new Categoria(null, "Cosmeticos");
		Categoria cat5 = new Categoria(null, "Limpeza");
		Categoria cat6 = new Categoria(null, "Laticineos");
		Categoria cat7 = new Categoria(null, "Padaria");

		Produto p1 = new Produto(null, "Computador", 2.500);
		Produto p2 = new Produto(null, "Impressora", 1.000);
		Produto p3 = new Produto(null, "Mouse", 50.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7));
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

		Endereco e1 = new Endereco(null, "logadouro", "10", "Na rua do Frango", "Recanto das Emas", "72640206", c4,
				cli2);
		Endereco e2 = new Endereco(null, "logadouro", "255", "Proximo ao primor", "Samambaia", "7254778", c4, cli1);

		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli1.getEnderecos().addAll(Arrays.asList(e2));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat est = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, est.parse("26/02/1988 14:31"), cli1, e1);
		Pedido ped2 = new Pedido(null, est.parse("18/04/1998 15:12"), cli1, e2);

		Pagamento pgt1 = new Pagamento_Com_Cartao(null, ped1, Estado_Pagamento.PENDENTE, 2);
		ped1.setPagamento(pgt1);

		Pagamento pgt2 = new Pagamento_Com_Boleto(null, ped2, Estado_Pagamento.QUITADO, est.parse("18/04/2001 21:03"),
				est.parse("18/04/200 21:15"));
		ped2.setPagamento(pgt2);

		cli1.getPedidos().addAll(Arrays.asList(ped1));
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgt2));

		ItemPedido ip1 = new ItemPedido(ped2, p3, 20.5, 2, 10.90);
		ItemPedido ip2 = new ItemPedido(ped2, p1, 2.5, 3, 12.50);
		ItemPedido ip3 = new ItemPedido(ped1, p2, 5.5, 1, 7.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip1));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}