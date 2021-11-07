package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Estado;
import com.dallan.petshop.dto.EstadoDTO;
import com.dallan.petshop.repositories.EstadoRepository;
import com.dallan.petshop.services.EstadoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/estados")
public class EstadoResource extends AbstractResource<Estado, Integer, EstadoDTO, EstadoRepository, EstadoService> {

	@Override
	public Estado makeEntityFromDTO(EstadoDTO dto) {
		return new Estado(dto.getId(), dto.getNome());
	}

	@Override
	public Estado mergeDTOIntoEntity(EstadoDTO dto, Estado entity) {
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		return entity;
	}

}
