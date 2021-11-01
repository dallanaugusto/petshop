package com.dallan.petshop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dallan.petshop.domain.Categoria;
import com.dallan.petshop.domain.Cidade;
import com.dallan.petshop.domain.Cliente;
import com.dallan.petshop.domain.Endereco;
import com.dallan.petshop.domain.Especie;
import com.dallan.petshop.domain.Estado;
import com.dallan.petshop.domain.Funcionario;
import com.dallan.petshop.domain.PagCartao;
import com.dallan.petshop.domain.PagDinheiro;
import com.dallan.petshop.domain.Pagamento;
import com.dallan.petshop.domain.Pessoa;
import com.dallan.petshop.domain.Pet;
import com.dallan.petshop.domain.Produto;
import com.dallan.petshop.domain.Raca;
import com.dallan.petshop.domain.Servico;
import com.dallan.petshop.domain.enums.SituacaoPagamento;
import com.dallan.petshop.repositories.CategoriaRepository;
import com.dallan.petshop.repositories.CidadeRepository;
import com.dallan.petshop.repositories.ClienteRepository;
import com.dallan.petshop.repositories.EnderecoRepository;
import com.dallan.petshop.repositories.EspecieRepository;
import com.dallan.petshop.repositories.EstadoRepository;
import com.dallan.petshop.repositories.FuncionarioRepository;
import com.dallan.petshop.repositories.PagCartaoRepository;
import com.dallan.petshop.repositories.PagDinheiroRepository;
import com.dallan.petshop.repositories.PetRepository;
import com.dallan.petshop.repositories.ProdutoRepository;
import com.dallan.petshop.repositories.RacaRepository;
import com.dallan.petshop.repositories.ServicoRepository;

@Component
public class PopulaDados {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EspecieRepository especieRepository;

	@Autowired
	private RacaRepository racaRepository;

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PagCartaoRepository pagCartaoRepository;

	@Autowired
	private PagDinheiroRepository pagDinheiroRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	@PostConstruct
	public void cadastrar() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Produto p1 = new Produto(null, "Ração", 100.0);
		Produto p2 = new Produto(null, "Sachê", 80.0);
		Produto p3 = new Produto(null, "Vermífugo", 20.0);
		Produto p4 = new Produto(null, "Shampoo", 50.0);

		Categoria cat1 = new Categoria(null, "Alimento");
		Categoria cat2 = new Categoria(null, "Remédio");
		Categoria cat3 = new Categoria(null, "Cosmético");

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat2.getProdutos().addAll(Arrays.asList(p3, p4));
		cat3.getProdutos().addAll(Arrays.asList(p4));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		Especie esp1 = new Especie(null, "Cachorro");
		Especie esp2 = new Especie(null, "Gato");

		especieRepository.saveAll(Arrays.asList(esp1, esp2));

		Raca rac1 = new Raca(null, "Shitzu");
		Raca rac2 = new Raca(null, "Akita");
		Raca rac3 = new Raca(null, "Persa");

		racaRepository.saveAll(Arrays.asList(rac1, rac2, rac3));

		Pet pet1 = new Pet(null, "John", 6, esp1, rac1);
		Pet pet2 = new Pet(null, "Hana", 5, esp1, rac2);
		Pet pet3 = new Pet(null, "Mewth", 8, esp2, rac3);

		petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		estadoRepository.saveAll(Arrays.asList(est1, est2));

		Cidade c1 = new Cidade(null, "Belo Horizonte", est1);
		Cidade c2 = new Cidade(null, "Capelinha", est1);
		Cidade c3 = new Cidade(null, "São Paulo", est2);

		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Pessoa pes1 = new Pessoa(null, "Jose Maria", "jose@mail.com", "335.194.320-21");
		Pessoa pes2 = new Pessoa(null, "Maria Jose", "maria@mail.com", "551.872.200.12");

		pes1.getTelefones().addAll(Arrays.asList("3516-2000", "9191-0000"));
		pes2.getTelefones().addAll(Arrays.asList("3279-0001", "9090-0002"));

		Cliente clt1 = new Cliente(null, "FISICA", pes1);

		clienteRepository.saveAll(Arrays.asList(clt1));

		Funcionario fnc1 = new Funcionario(null, "ATENDENTE", pes2);

		funcionarioRepository.saveAll(Arrays.asList(fnc1));

		Endereco end1 = new Endereco(null, "Rua Tupis", "500", "Apto 101", "Pindorama", "30111222", pes1, c1);
		Endereco end2 = new Endereco(null, "Av. Tamoios", "100", "Casa", "Oca", "3968000", pes2, c2);
		Endereco end3 = new Endereco(null, "Rua Aranãs", "10", "Apto 201", "Centro", "01153000", pes2, c3);

		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));

		Servico srv1 = new Servico(null, sdf.parse("02/09/2021 09:00"), sdf.parse("02/09/2021 12:00"), "Tosa", clt1,
				fnc1, pet1);
		Servico srv2 = new Servico(null, sdf.parse("03/09/2021 12:00"), sdf.parse("04/09/2021 12:00"), "Hotel", clt1,
				fnc1, pet2);
		Servico srv3 = new Servico(null, sdf.parse("05/09/2021 16:00"), sdf.parse("05/09/2021 16:30"), "Vermifugação",
				clt1, fnc1, pet3);

		servicoRepository.saveAll(Arrays.asList(srv1, srv2, srv3));

		srv2.getProdutos().addAll(Arrays.asList(p1, p2, p4));
		srv3.getProdutos().addAll(Arrays.asList(p3));

		servicoRepository.saveAll(Arrays.asList(srv1, srv2, srv3));

		PagCartao pgc1 = new PagCartao(null, 6, new Pagamento(null, SituacaoPagamento.QUITADO, srv2));

		pagCartaoRepository.saveAll(Arrays.asList(pgc1));

		PagDinheiro pgd1 = new PagDinheiro(null, sdf.parse("20/10/2021 00:00"), null,
				new Pagamento(null, SituacaoPagamento.PENDENTE, srv1));
		PagDinheiro pgd2 = new PagDinheiro(null, sdf.parse("05/09/2021 16:30"), null,
				new Pagamento(null, SituacaoPagamento.QUITADO, srv3));

		pagDinheiroRepository.saveAll(Arrays.asList(pgd1, pgd2));
	}

}
