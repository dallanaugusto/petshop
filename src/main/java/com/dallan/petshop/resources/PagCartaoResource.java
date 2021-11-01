package com.dallan.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.PagCartao;
import com.dallan.petshop.dto.PagCartaoDTO;
import com.dallan.petshop.repositories.PagCartaoRepository;
import com.dallan.petshop.services.PagCartaoService;
import com.dallan.petshop.services.PagamentoService;

@RestController
@RequestMapping(value = "/pagcartoes")
public class PagCartaoResource
		extends AbstractResource<PagCartao, Integer, PagCartaoDTO, PagCartaoRepository, PagCartaoService> {

	@Autowired
	private PagamentoService pagamentoService;

	@Override
	public PagCartao makeEntityFromDTO(PagCartaoDTO dto) {
		return new PagCartao(dto.getId(), dto.getParcelas(), pagamentoService.find(dto.getPagamento()));
	}

	@Override
	public PagCartao mergeDTOIntoEntity(PagCartaoDTO dto, PagCartao entity) {
		entity.setId(dto.getId());
		entity.setParcelas(dto.getParcelas());
		entity.setPagamento(pagamentoService.find(dto.getPagamento()));
		return entity;
	}

}
