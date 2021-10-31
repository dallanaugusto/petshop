package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Cidade;
import com.dallan.petshop.repositories.CidadeRepository;
import com.dallan.petshop.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource extends AbstractResource<Cidade, Integer, CidadeRepository, CidadeService> {

	@Override
	public Cidade copyAtributosParaUpdate(Cidade obj, Cidade other) {
		obj.setNome(other.getNome());
		obj.setEstado(other.getEstado());
		return obj;
	}

}
