package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Cliente;

public class ClienteDTO extends AbstractDTO<Cliente, Integer> {

	private static final long serialVersionUID = -4508902340431984130L;

	private String nome;
	private String email;
	private String codNacional;
	private String tipo;

	@Override
	public void copyFromEntity(Cliente entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.codNacional = entity.getCodNacional();
		this.tipo = entity.getTipo();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodNacional() {
		return codNacional;
	}

	public void setCodNacional(String codNacional) {
		this.codNacional = codNacional;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
