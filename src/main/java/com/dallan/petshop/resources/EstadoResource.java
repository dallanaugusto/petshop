package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Estado;
import com.dallan.petshop.repositories.EstadoRepository;
import com.dallan.petshop.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource extends AbstractResource<Estado, Integer, EstadoRepository, EstadoService> {

	@Override
	public Estado copyAtributosParaUpdate(Estado obj, Estado other) {
		obj.setNome(other.getNome());
		return obj;
	}

}
