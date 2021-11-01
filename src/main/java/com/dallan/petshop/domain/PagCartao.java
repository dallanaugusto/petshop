package com.dallan.petshop.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PagCartao extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -6307641101089248770L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer parcelas;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pagamento")
	private Pagamento pagamento;

	public PagCartao() {

	}

	public PagCartao(Integer id, Integer parcelas, Pagamento pagamento) {
		super();

		this.id = id;
		this.parcelas = parcelas;
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

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

}
