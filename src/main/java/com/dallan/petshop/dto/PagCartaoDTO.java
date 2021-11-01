package com.dallan.petshop.dto;

import com.dallan.petshop.domain.PagCartao;

public class PagCartaoDTO extends AbstractDTO<PagCartao, Integer> {

	private static final long serialVersionUID = -6210756431396417593L;

	private Integer parcelas;
	private Integer pagamento;

	@Override
	public void copyFromEntity(PagCartao entity) {
		this.id = entity.getId();
		this.parcelas = entity.getParcelas();
		this.pagamento = entity.getPagamento().getId();
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public Integer getPagamento() {
		return pagamento;
	}

	public void setPagamento(Integer pagamento) {
		this.pagamento = pagamento;
	}

}
