package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Especie;
import com.dallan.petshop.dto.EspecieDTO;
import com.dallan.petshop.repositories.EspecieRepository;
import com.dallan.petshop.services.EspecieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/especies")
public class EspecieResource extends AbstractResource<Especie, Integer, EspecieDTO, EspecieRepository, EspecieService> {

	@Override
	public Especie makeEntityFromDTO(EspecieDTO dto) {
		return new Especie(dto.getId(), dto.getDescricao());
	}

	@Override
	public Especie mergeDTOIntoEntity(EspecieDTO dto, Especie entity) {
		entity.setId(dto.getId());
		entity.setDescricao(dto.getDescricao());
		return entity;
	}

}
