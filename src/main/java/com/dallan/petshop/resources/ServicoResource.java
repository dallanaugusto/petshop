package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Servico;
import com.dallan.petshop.repositories.ServicoRepository;
import com.dallan.petshop.services.ServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource extends AbstractResource<Servico, Integer, ServicoRepository, ServicoService> {

	@Override
	public Servico copyAtributosParaUpdate(Servico obj, Servico other) {
		obj.setDataEntrada(other.getDataEntrada());
		obj.setDataSaida(other.getDataSaida());
		obj.setDescricao(other.getDescricao());
		obj.setPagamento(other.getPagamento());
		obj.setCliente(other.getCliente());
		obj.setFuncionario(other.getFuncionario());
		obj.setPet(other.getPet());

		return obj;
	}

}