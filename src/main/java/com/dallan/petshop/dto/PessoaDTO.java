package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Pessoa;

public class PessoaDTO extends AbstractDTO<Pessoa, Integer> {

	private static final long serialVersionUID = 3573312859727054454L;

	private String nome;
	private String email;
	private String codNacional;

	@Override
	public void copyFromEntity(Pessoa entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.codNacional = entity.getCodNacional();
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

}
