package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Categoria;

public class CategoriaDTO extends AbstractDTO<Categoria, Integer> {

	private static final long serialVersionUID = -3315859787094605146L;

	private String nome;

	@Override
	public void copyFromEntity(Categoria entity) {
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
