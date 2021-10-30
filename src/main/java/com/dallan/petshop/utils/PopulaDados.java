package com.dallan.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dallan.petshop.domain.Categoria;
import com.dallan.petshop.repositories.CategoriaRepository;

@Component
public class PopulaDados {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostConstruct
	public void cadastrar() {

		Categoria cat1 = new Categoria(null, "Alimento");
		Categoria cat2 = new Categoria(null, "Remédio");
		Categoria cat3 = new Categoria(null, "Cosmético");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}

}
