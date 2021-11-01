package com.dallan.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Pagamento;
import com.dallan.petshop.domain.enums.SituacaoPagamento;
import com.dallan.petshop.dto.PagamentoDTO;
import com.dallan.petshop.repositories.PagamentoRepository;
import com.dallan.petshop.services.PagamentoService;
import com.dallan.petshop.services.ServicoService;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResource
		extends AbstractResource<Pagamento, Integer, PagamentoDTO, PagamentoRepository, PagamentoService> {

	@Autowired
	private ServicoService servicoService;

	@Override
	public Pagamento makeEntityFromDTO(PagamentoDTO dto) {
		return new Pagamento(dto.getId(), SituacaoPagamento.toEnum(dto.getSituacao()),
				servicoService.find(dto.getServico()));
	}

	@Override
	public Pagamento mergeDTOIntoEntity(PagamentoDTO dto, Pagamento entity) {
		entity.setId(dto.getId());
		entity.setSituacao(SituacaoPagamento.toEnum(dto.getSituacao()));
		entity.setServico(servicoService.find(dto.getServico()));
		return entity;
	}

}
