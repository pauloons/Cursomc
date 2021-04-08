package com.alexandre.cursos.services;

import com.alexandre.cursos.domain.*;
import com.alexandre.cursos.domain.enums.Estado_Pagamento;
import com.alexandre.cursos.domain.enums.Tipo_Cliente;
import com.alexandre.cursos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

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
    public void instantiateTesteDatabase() throws ParseException {

        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");
        Categoria cat3 = new Categoria(null, "Açougue");
        Categoria cat4 = new Categoria(null, "Cosmeticos");
        Categoria cat5 = new Categoria(null, "Limpeza");
        Categoria cat6 = new Categoria(null, "Laticineos");
        Categoria cat7 = new Categoria(null, "Padaria");


        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);
        Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
        Produto p5 = new Produto(null, "Toalha", 50.00);
        Produto p6 = new Produto(null, "Colcha", 200.00);
        Produto p7 = new Produto(null, "TV true color", 1200.00);
        Produto p8 = new Produto(null, "Roçadeira", 800.00);
        Produto p9 = new Produto(null, "Abajour", 100.00);
        Produto p10 = new Produto(null, "Pendente", 180.00);
        Produto p11 = new Produto(null, "Shampoo", 90.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        cat2.getProdutos().addAll(Arrays.asList(p2, p4));
        cat3.getProdutos().addAll(Arrays.asList(p5, p6));
        cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
        cat5.getProdutos().addAll(Arrays.asList(p8));
        cat6.getProdutos().addAll(Arrays.asList(p9, p10));
        cat7.getProdutos().addAll(Arrays.asList(p11));

        p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p4.getCategorias().addAll(Arrays.asList(cat2));
        p5.getCategorias().addAll(Arrays.asList(cat3));
        p6.getCategorias().addAll(Arrays.asList(cat3));
        p7.getCategorias().addAll(Arrays.asList(cat4));
        p8.getCategorias().addAll(Arrays.asList(cat5));
        p9.getCategorias().addAll(Arrays.asList(cat6));
        p10.getCategorias().addAll(Arrays.asList(cat6));
        p11.getCategorias().addAll(Arrays.asList(cat7));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7));
        //produtosRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Brasilia");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Campinas", est1);
        Cidade c2 = new Cidade(null, "Andradina", est2);
        Cidade c3 = new Cidade(null, "Guarujá", est2);
        Cidade c4 = new Cidade(null, "Recanto", est2);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

        Cliente cli1 = new Cliente(null, "Paulo", "pauloons@gmail.com", "0238050923", Tipo_Cliente.PESSOAFISICA);
        Cliente cli2 = new Cliente(null, "Thamyres", "thamyres@gmail.com", "017657745", Tipo_Cliente.PESSOAFISICA);
        Cliente cli3 = new Cliente(null, "Gabriel", "gabi@gmail.com", "0238050923", Tipo_Cliente.PESSOAJURIDICA);

        cli1.getTelefones().addAll(Arrays.asList("981019380", "34346067"));
        cli2.getTelefones().addAll(Arrays.asList("984554845", "33545564"));

        Endereco e1 = new Endereco(null, "qd 203", "10", "Na rua do Frango", "Recanto das Emas", "72640206", c4,
                cli2);
        Endereco e2 = new Endereco(null, "qd 406", "255", "Proximo ao primor", "Samambaia", "7254778", c3, cli1);

        //Endereco e3 = new Endereco(null, "qd 603", "555", "Proximo ao Euro", "Riacho", "7254778", c2, cli3);

        cli1.getEnderecos().addAll(Arrays.asList(e1));
        cli1.getEnderecos().addAll(Arrays.asList(e2));

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

        SimpleDateFormat est = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido ped1 = new Pedido(null, est.parse("26/02/1988 14:31"), cli1, e1);
        Pedido ped2 = new Pedido(null, est.parse("18/04/1998 15:12"), cli2, e2);
        //Pedido ped3 = new Pedido(null, est.parse("22/09/1983 14:32"), cli3, e3);


        Pagamento pgt1 = new Pagamento_Com_Cartao(null, ped1, Estado_Pagamento.PENDENTE, 2);
        ped1.setPagamento(pgt1);

        Pagamento pgt2 = new Pagamento_Com_Boleto(null, ped2, Estado_Pagamento.QUITADO, est.parse("18/04/2001 21:03"),
                est.parse("18/04/200 21:15"));
        ped2.setPagamento(pgt2);

        Pagamento pgt3 = new Pagamento_Com_Cartao(null, ped1, Estado_Pagamento.PENDENTE, 3);
        ped1.setPagamento(pgt3);

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
