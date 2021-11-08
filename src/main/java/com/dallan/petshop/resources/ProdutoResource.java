package com.dallan.petshop.resources;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Categoria;
import com.dallan.petshop.domain.Produto;
import com.dallan.petshop.dto.ProdutoDTO;
import com.dallan.petshop.repositories.ProdutoRepository;
import com.dallan.petshop.services.CategoriaService;
import com.dallan.petshop.services.ProdutoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/produtos")
public class ProdutoResource extends AbstractResource<Produto, Integer, ProdutoDTO, ProdutoRepository, ProdutoService> {

	@Autowired
	private CategoriaService categoriaService;

	@Override
	public Produto makeEntityFromDTO(ProdutoDTO dto) {
		Produto produto = new Produto(dto.getId(), dto.getNome(), dto.getPreco());

		if (dto.getCategorias() != null) {
			for (Integer categoriaId : dto.getCategorias()) {
				Categoria categoria = categoriaService.find(categoriaId);

				produto.getCategorias().add(categoria);
			}
		}

		return produto;
	}

	@Override
	public Produto mergeDTOIntoEntity(ProdutoDTO dto, Produto entity) {
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setPreco(dto.getPreco());
		
		if (dto.getCategorias() != null) {
			
			entity.setCategorias(new ArrayList<>());
			
			for (Integer categoriaId : dto.getCategorias()) {
				Categoria categoria = categoriaService.find(categoriaId);

				entity.getCategorias().add(categoria);
			}
		}
		
		return entity;
	}

}
