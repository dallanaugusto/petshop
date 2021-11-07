package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Categoria;
import com.dallan.petshop.dto.CategoriaDTO;
import com.dallan.petshop.repositories.CategoriaRepository;
import com.dallan.petshop.services.CategoriaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/categorias")
public class CategoriaResource
		extends AbstractResource<Categoria, Integer, CategoriaDTO, CategoriaRepository, CategoriaService> {

	@Override
	public Categoria makeEntityFromDTO(CategoriaDTO dto) {
		return new Categoria(dto.getId(), dto.getNome());
	}

	@Override
	public Categoria mergeDTOIntoEntity(CategoriaDTO dto, Categoria entity) {
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		return entity;
	}

}
