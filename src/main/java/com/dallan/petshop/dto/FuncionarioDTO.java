package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Funcionario;

public class FuncionarioDTO extends AbstractDTO<Funcionario, Integer> {

	private static final long serialVersionUID = 406215418233398349L;

	private String nome;
	private String email;
	private String codNacional;
	private String funcao;

	@Override
	public void copyFromEntity(Funcionario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.codNacional = entity.getCodNacional();
		this.funcao = entity.getFuncao();
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}
