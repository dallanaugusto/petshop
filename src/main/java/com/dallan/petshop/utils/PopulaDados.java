package com.dallan.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dallan.petshop.domain.Categoria;
import com.dallan.petshop.domain.Especie;
import com.dallan.petshop.domain.Pet;
import com.dallan.petshop.domain.Produto;
import com.dallan.petshop.domain.Raca;
import com.dallan.petshop.repositories.CategoriaRepository;
import com.dallan.petshop.repositories.EspecieRepository;
import com.dallan.petshop.repositories.PetRepository;
import com.dallan.petshop.repositories.ProdutoRepository;
import com.dallan.petshop.repositories.RacaRepository;

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

	@PostConstruct
	public void cadastrar() {

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
	}

}
