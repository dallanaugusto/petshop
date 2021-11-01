package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Pet;

public class PetDTO extends AbstractDTO<Pet, Integer> {

	private static final long serialVersionUID = -7311458515609251313L;

	private String nome;
	private Integer idade;
	private Integer especie;
	private Integer raca;

	@Override
	public void copyFromEntity(Pet entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.idade = entity.getIdade();
		this.especie = entity.getEspecie().getId();
		this.raca = entity.getRaca().getId();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getEspecie() {
		return especie;
	}

	public void setEspecie(Integer especie) {
		this.especie = especie;
	}

	public Integer getRaca() {
		return raca;
	}

	public void setRaca(Integer raca) {
		this.raca = raca;
	}

}
