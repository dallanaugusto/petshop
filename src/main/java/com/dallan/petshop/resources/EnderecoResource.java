package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Endereco;
import com.dallan.petshop.repositories.EnderecoRepository;
import com.dallan.petshop.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource extends AbstractResource<Endereco, Integer, EnderecoRepository, EnderecoService> {

	@Override
	public Endereco copyAtributosParaUpdate(Endereco obj, Endereco other) {
		obj.setLogradouro(other.getLogradouro());
		obj.setNumero(other.getNumero());
		obj.setComplemento(other.getComplemento());
		obj.setBairro(other.getBairro());
		obj.setCep(other.getCep());

		return obj;
	}

}
