package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Estado;

public class EstadoDTO extends AbstractDTO<Estado, Integer> {

	private static final long serialVersionUID = 4863467837550981341L;

	private String nome;

	@Override
	public void copyFromEntity(Estado entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
