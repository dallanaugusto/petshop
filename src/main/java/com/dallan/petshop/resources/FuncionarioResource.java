package com.dallan.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Funcionario;
import com.dallan.petshop.dto.FuncionarioDTO;
import com.dallan.petshop.repositories.FuncionarioRepository;
import com.dallan.petshop.services.FuncionarioService;
import com.dallan.petshop.services.PessoaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource
		extends AbstractResource<Funcionario, Integer, FuncionarioDTO, FuncionarioRepository, FuncionarioService> {

	@Autowired
	private PessoaService pessoaService;

	@Override
	public Funcionario makeEntityFromDTO(FuncionarioDTO dto) {
		return new Funcionario(dto.getId(), dto.getFuncao(), pessoaService.find(dto.getPessoa()));
	}

	@Override
	public Funcionario mergeDTOIntoEntity(FuncionarioDTO dto, Funcionario entity) {
		entity.setId(dto.getId());
		entity.setFuncao(dto.getFuncao());
		entity.setPessoa(pessoaService.find(dto.getPessoa()));
		return entity;
	}

}
