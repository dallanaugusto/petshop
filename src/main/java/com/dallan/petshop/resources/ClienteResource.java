package com.dallan.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Cliente;
import com.dallan.petshop.dto.ClienteDTO;
import com.dallan.petshop.repositories.ClienteRepository;
import com.dallan.petshop.services.ClienteService;
import com.dallan.petshop.services.PessoaService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource extends AbstractResource<Cliente, Integer, ClienteDTO, ClienteRepository, ClienteService> {

	@Autowired
	private PessoaService pessoaService;

	@Override
	public Cliente makeEntityFromDTO(ClienteDTO dto) {
		return new Cliente(dto.getId(), dto.getTipo(), pessoaService.find(dto.getPessoa()));
	}

	@Override
	public Cliente mergeDTOIntoEntity(ClienteDTO dto, Cliente entity) {
		entity.setId(dto.getId());
		entity.setTipo(dto.getTipo());
		entity.setPessoa(pessoaService.find(dto.getPessoa()));
		return entity;
	}

}
