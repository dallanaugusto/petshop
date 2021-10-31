package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Produto;
import com.dallan.petshop.repositories.ProdutoRepository;
import com.dallan.petshop.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource extends AbstractResource<Produto, Integer, ProdutoRepository, ProdutoService> {

	@Override
	public Produto copyAtributosParaUpdate(Produto obj, Produto other) {
		obj.setNome(other.getNome());
		obj.setPreco(other.getPreco());
		return obj;
	}

}
