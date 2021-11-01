package com.dallan.petshop.dto;

import com.dallan.petshop.domain.PagCartao;

public class PagCartaoDTO extends AbstractDTO<PagCartao, Integer> {

	private static final long serialVersionUID = -6210756431396417593L;

	private String situacao;
	private Integer servico;
	private Integer parcelas;

	@Override
	public void copyFromEntity(PagCartao entity) {
		this.id = entity.getId();
		this.situacao = entity.getSituacao().getDescricao();
		this.servico = entity.getServico().getId();
		this.parcelas = entity.getParcelas();
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Integer getServico() {
		return servico;
	}

	public void setServico(Integer servico) {
		this.servico = servico;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

}
