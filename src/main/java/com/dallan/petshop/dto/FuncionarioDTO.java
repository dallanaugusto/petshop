package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Funcionario;

public class FuncionarioDTO extends AbstractDTO<Funcionario, Integer> {

	private static final long serialVersionUID = 406215418233398349L;

	private String funcao;
	private Integer pessoa;

	@Override
	public void copyFromEntity(Funcionario entity) {
		this.id = entity.getId();
		this.funcao = entity.getFuncao();
		this.pessoa = entity.getPessoa().getId();
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Integer getPessoa() {
		return pessoa;
	}

	public void setPessoa(Integer pessoa) {
		this.pessoa = pessoa;
	}

}
