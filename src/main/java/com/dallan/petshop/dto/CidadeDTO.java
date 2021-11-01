package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Cidade;

public class CidadeDTO extends AbstractDTO<Cidade, Integer> {

	private static final long serialVersionUID = 8835147583838231255L;

	private String nome;
	private Integer estado;

	@Override
	public void copyFromEntity(Cidade entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.estado = entity.getEstado().getId();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
