package com.dallan.petshop.domain;

import javax.persistence.Entity;

import com.dallan.petshop.domain.enums.SituacaoPagamento;

@Entity
public class PagCartao extends Pagamento {

	private static final long serialVersionUID = -6307641101089248770L;

	private Integer parcelas;

	public PagCartao() {

	}

	public PagCartao(Integer id, SituacaoPagamento situacao, Servico servico, Integer parcelas) {
		super(id, situacao, servico);
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

}
