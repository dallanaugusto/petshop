package com.dallan.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Cidade;
import com.dallan.petshop.dto.CidadeDTO;
import com.dallan.petshop.repositories.CidadeRepository;
import com.dallan.petshop.services.CidadeService;
import com.dallan.petshop.services.EstadoService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource extends AbstractResource<Cidade, Integer, CidadeDTO, CidadeRepository, CidadeService> {

	@Autowired
	private EstadoService estadoService;

	@Override
	public Cidade makeEntityFromDTO(CidadeDTO dto) {
		return new Cidade(dto.getId(), dto.getNome(), estadoService.find(dto.getEstado()));
	}

	@Override
	public Cidade mergeDTOIntoEntity(CidadeDTO dto, Cidade entity) {
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setEstado(estadoService.find(dto.getEstado()));
		return entity;
	}

}
