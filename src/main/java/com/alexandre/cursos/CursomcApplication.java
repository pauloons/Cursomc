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
import com.alexandre.cursos.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}