package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Pessoa;
import com.dallan.petshop.dto.PessoaDTO;
import com.dallan.petshop.repositories.PessoaRepository;
import com.dallan.petshop.services.PessoaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/pessoas")
public class PessoaResource extends AbstractResource<Pessoa, Integer, PessoaDTO, PessoaRepository, PessoaService> {

	@Override
	public Pessoa makeEntityFromDTO(PessoaDTO dto) {
		return new Pessoa(dto.getId(), dto.getNome(), dto.getEmail(), dto.getCodNacional());
	}

	@Override
	public Pessoa mergeDTOIntoEntity(PessoaDTO dto, Pessoa entity) {
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setCodNacional(dto.getCodNacional());
		return entity;
	}

}
