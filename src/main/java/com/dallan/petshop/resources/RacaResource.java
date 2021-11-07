package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Raca;
import com.dallan.petshop.dto.RacaDTO;
import com.dallan.petshop.repositories.RacaRepository;
import com.dallan.petshop.services.RacaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/racas")
public class RacaResource extends AbstractResource<Raca, Integer, RacaDTO, RacaRepository, RacaService> {

	@Override
	public Raca makeEntityFromDTO(RacaDTO dto) {
		return new Raca(dto.getId(), dto.getDescricao());
	}

	@Override
	public Raca mergeDTOIntoEntity(RacaDTO dto, Raca entity) {
		entity.setId(dto.getId());
		entity.setDescricao(dto.getDescricao());
		return entity;
	}

}
