package com.dallan.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.PagDinheiro;
import com.dallan.petshop.dto.PagDinheiroDTO;
import com.dallan.petshop.repositories.PagDinheiroRepository;
import com.dallan.petshop.services.PagDinheiroService;
import com.dallan.petshop.services.PagamentoService;

@RestController
@RequestMapping(value = "/pagdinheiros")
public class PagDinheiroResource
		extends AbstractResource<PagDinheiro, Integer, PagDinheiroDTO, PagDinheiroRepository, PagDinheiroService> {

	@Autowired
	private PagamentoService pagamentoService;

	@Override
	public PagDinheiro makeEntityFromDTO(PagDinheiroDTO dto) {
		return new PagDinheiro(dto.getId(), dto.getDataVencimento(), dto.getDesconto(),
				pagamentoService.find(dto.getPagamento()));
	}

	@Override
	public PagDinheiro mergeDTOIntoEntity(PagDinheiroDTO dto, PagDinheiro entity) {
		entity.setId(dto.getId());
		entity.setDataVencimento(dto.getDataVencimento());
		entity.setDesconto(dto.getDesconto());
		entity.setPagamento(pagamentoService.find(dto.getPagamento()));
		return entity;
	}

}
