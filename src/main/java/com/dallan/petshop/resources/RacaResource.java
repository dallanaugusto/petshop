package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Raca;
import com.dallan.petshop.repositories.RacaRepository;
import com.dallan.petshop.services.RacaService;

@RestController
@RequestMapping(value = "/racas")
public class RacaResource extends AbstractResource<Raca, Integer, RacaRepository, RacaService> {

	@Override
	public Raca copyAtributosParaUpdate(Raca obj, Raca other) {
		obj.setDescricao(other.getDescricao());
		return obj;
	}

}
