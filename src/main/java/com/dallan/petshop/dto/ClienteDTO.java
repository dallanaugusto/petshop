package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Cliente;

public class ClienteDTO extends AbstractDTO<Cliente, Integer> {

	private static final long serialVersionUID = -4508902340431984130L;

	private String tipo;
	private Integer pessoa;

	@Override
	public void copyFromEntity(Cliente entity) {
		this.id = entity.getId();
		this.tipo = entity.getTipo();
		this.pessoa = entity.getPessoa().getId();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getPessoa() {
		return pessoa;
	}

	public void setPessoa(Integer pessoa) {
		this.pessoa = pessoa;
	}

}
