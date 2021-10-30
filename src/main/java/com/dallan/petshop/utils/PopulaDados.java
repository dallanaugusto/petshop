package com.dallan.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dallan.petshop.domain.Categoria;
import com.dallan.petshop.domain.Produto;
import com.dallan.petshop.repositories.CategoriaRepository;
import com.dallan.petshop.repositories.ProdutoRepository;

@Component
public class PopulaDados {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

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

		/*
		 * p1.getCategorias().addAll(Arrays.asList(cat1));
		 * p2.getCategorias().addAll(Arrays.asList(cat1));
		 * p3.getCategorias().addAll(Arrays.asList(cat2));
		 * p4.getCategorias().addAll(Arrays.asList(cat2, cat3));
		 */

		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat2.getProdutos().addAll(Arrays.asList(p3, p4));
		cat3.getProdutos().addAll(Arrays.asList(p4));

		// produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}

}
