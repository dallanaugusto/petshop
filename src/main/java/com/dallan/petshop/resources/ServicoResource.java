package com.dallan.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Cliente;
import com.dallan.petshop.domain.Funcionario;
import com.dallan.petshop.domain.Servico;
import com.dallan.petshop.dto.ServicoDTO;
import com.dallan.petshop.repositories.ServicoRepository;
import com.dallan.petshop.services.ClienteService;
import com.dallan.petshop.services.FuncionarioService;
import com.dallan.petshop.services.PagamentoService;
import com.dallan.petshop.services.PetService;
import com.dallan.petshop.services.ServicoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/servicos")
public class ServicoResource extends AbstractResource<Servico, Integer, ServicoDTO, ServicoRepository, ServicoService> {

	@Autowired
	private PagamentoService pagamentoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private PetService petService;

	@Override
	public Servico makeEntityFromDTO(ServicoDTO dto) {
		return new Servico(dto.getId(), dto.getDataEntrada(), dto.getDataSaida(), dto.getDescricao(),
				pagamentoService.find(dto.getPagamento()), clienteService.find(dto.getCliente()),
				funcionarioService.find(dto.getFuncionario()), petService.find(dto.getPet()));
	}

	@Override
	public Servico mergeDTOIntoEntity(ServicoDTO dto, Servico entity) {
		entity.setId(dto.getId());
		entity.setDataEntrada(dto.getDataEntrada());
		entity.setDataSaida(dto.getDataSaida());
		entity.setDescricao(dto.getDescricao());
		entity.setPagamento(pagamentoService.find(dto.getPagamento()));
		entity.setCliente((Cliente) clienteService.find(dto.getCliente()));
		entity.setFuncionario((Funcionario) funcionarioService.find(dto.getFuncionario()));
		entity.setPet(petService.find(dto.getPet()));
		return entity;
	}

}