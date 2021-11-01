package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Pagamento;

public class PagamentoDTO extends AbstractDTO<Pagamento, Integer> {

	private static final long serialVersionUID = -3611032568602697886L;

	private Integer situacao;
	private Integer servico;

	@Override
	public void copyFromEntity(Pagamento entity) {
		this.id = entity.getId();
		this.situacao = entity.getSituacao().getCod();
		this.servico = entity.getServico().getId();
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Integer getServico() {
		return servico;
	}

	public void setServico(Integer servico) {
		this.servico = servico;
	}

}
