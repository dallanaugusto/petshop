package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Especie;

public class EspecieDTO extends AbstractDTO<Especie, Integer> {

	private static final long serialVersionUID = 7584877415311404320L;

	private String descricao;

	@Override
	public void copyFromEntity(Especie entity) {
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
