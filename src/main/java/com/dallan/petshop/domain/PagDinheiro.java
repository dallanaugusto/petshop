package com.dallan.petshop.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.dallan.petshop.domain.enums.SituacaoPagamento;

@Entity
public class PagDinheiro extends Pagamento {

	private static final long serialVersionUID = -241723093946346362L;

	private Date dataPagamento;
	private Double desconto;

	public PagDinheiro() {

	}

	public PagDinheiro(Integer id, Double valor, SituacaoPagamento situacao, Servico servico, Date dataPagamento,
			Double desconto) {
		super(id, valor, situacao, servico);
		this.dataPagamento = dataPagamento;
		this.desconto = desconto;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

}
