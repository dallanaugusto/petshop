package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Categoria;
import com.dallan.petshop.repositories.CategoriaRepository;
import com.dallan.petshop.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource extends AbstractResource<Categoria, Integer, CategoriaRepository, CategoriaService> {

	@Override
	public Categoria copyAtributosParaUpdate(Categoria obj, Categoria other) {
		obj.setNome(other.getNome());
		return obj;
	}

}
