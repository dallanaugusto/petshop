package com.dallan.petshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dallan.petshop.domain.Categoria;
import com.dallan.petshop.repositories.CategoriaRepository;
import com.dallan.petshop.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(id, Categoria.class));
	}

}
