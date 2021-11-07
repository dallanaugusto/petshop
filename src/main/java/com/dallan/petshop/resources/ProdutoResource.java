package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Produto;
import com.dallan.petshop.dto.ProdutoDTO;
import com.dallan.petshop.repositories.ProdutoRepository;
import com.dallan.petshop.services.ProdutoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/produtos")
public class ProdutoResource extends AbstractResource<Produto, Integer, ProdutoDTO, ProdutoRepository, ProdutoService> {

	@Override
	public Produto makeEntityFromDTO(ProdutoDTO dto) {
		return new Produto(dto.getId(), dto.getNome(), dto.getPreco());
	}

	@Override
	public Produto mergeDTOIntoEntity(ProdutoDTO dto, Produto entity) {
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setPreco(dto.getPreco());
		return entity;
	}

}
