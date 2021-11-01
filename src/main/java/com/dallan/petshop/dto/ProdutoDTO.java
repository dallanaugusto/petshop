package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Produto;

public class ProdutoDTO extends AbstractDTO<Produto, Integer> {

	private static final long serialVersionUID = -3585376030285362130L;

	private String nome;
	private Double preco;

	@Override
	public void copyFromEntity(Produto entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
