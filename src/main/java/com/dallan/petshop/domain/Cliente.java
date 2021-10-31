package com.dallan.petshop.domain;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {

	private static final long serialVersionUID = -4113059067483766639L;

	private String tipo;

	public Cliente() {

	}

	public Cliente(Integer id, String nome, String email, String codNacional, String tipo) {
		super(id, nome, email, codNacional);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
