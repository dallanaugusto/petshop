package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Especie;
import com.dallan.petshop.repositories.EspecieRepository;
import com.dallan.petshop.services.EspecieService;

@RestController
@RequestMapping(value = "/especies")
public class EspecieResource extends AbstractResource<Especie, Integer, EspecieRepository, EspecieService> {

	@Override
	public Especie copyAtributosParaUpdate(Especie obj, Especie other) {
		obj.setDescricao(other.getDescricao());
		return obj;
	}

}
