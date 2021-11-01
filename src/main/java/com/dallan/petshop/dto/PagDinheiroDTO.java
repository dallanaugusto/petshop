package com.dallan.petshop.dto;

import java.util.Date;

import com.dallan.petshop.domain.PagDinheiro;

public class PagDinheiroDTO extends AbstractDTO<PagDinheiro, Integer> {

	private static final long serialVersionUID = 3724399163686037073L;

	private String situacao;
	private Integer servico;
	private Date dataVencimento;
	private Double desconto;

	@Override
	public void copyFromEntity(PagDinheiro entity) {
		this.id = entity.getId();
		this.situacao = entity.getSituacao().getDescricao();
		this.servico = entity.getServico().getId();
		this.dataVencimento = entity.getDataVencimento();
		this.desconto = entity.getDesconto();
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

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

}
