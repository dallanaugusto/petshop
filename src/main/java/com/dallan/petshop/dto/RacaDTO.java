package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Raca;

public class RacaDTO extends AbstractDTO<Raca, Integer> {

	private static final long serialVersionUID = 4884581243395777266L;

	private String descricao;

	@Override
	public void copyFromEntity(Raca entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
