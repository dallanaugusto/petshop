package com.dallan.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Endereco;
import com.dallan.petshop.dto.EnderecoDTO;
import com.dallan.petshop.repositories.EnderecoRepository;
import com.dallan.petshop.services.CidadeService;
import com.dallan.petshop.services.EnderecoService;
import com.dallan.petshop.services.PessoaService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource
		extends AbstractResource<Endereco, Integer, EnderecoDTO, EnderecoRepository, EnderecoService> {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private CidadeService cidadeService;

	@Override
	public Endereco makeEntityFromDTO(EnderecoDTO dto) {
		return new Endereco(dto.getId(), dto.getLogradouro(), dto.getNumero(), dto.getComplemento(), dto.getBairro(),
				dto.getCep(), pessoaService.find(dto.getPessoa()), cidadeService.find(dto.getCidade()));
	}

	@Override
	public Endereco mergeDTOIntoEntity(EnderecoDTO dto, Endereco entity) {
		entity.setId(dto.getId());
		entity.setLogradouro(dto.getLogradouro());
		entity.setNumero(dto.getNumero());
		entity.setComplemento(dto.getComplemento());
		entity.setBairro(dto.getBairro());
		entity.setCep(dto.getCep());
		entity.setPessoa(pessoaService.find(dto.getPessoa()));
		entity.setCidade(cidadeService.find(dto.getCidade()));
		return entity;
	}

}
