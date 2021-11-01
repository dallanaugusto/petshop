package com.dallan.petshop.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PagDinheiro extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -241723093946346362L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataVencimento;
	private Double desconto;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pagamento")
	private Pagamento pagamento;

	public PagDinheiro() {

	}

	public PagDinheiro(Integer id, Date dataVencimento, Double desconto, Pagamento pagamento) {
		super();

		this.id = id;
		this.dataVencimento = dataVencimento;
		this.desconto = desconto;
		this.pagamento = pagamento;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
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

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

}
