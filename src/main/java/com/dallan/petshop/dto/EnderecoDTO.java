package com.dallan.petshop.dto;

import com.dallan.petshop.domain.Endereco;

public class EnderecoDTO extends AbstractDTO<Endereco, Integer> {

	private static final long serialVersionUID = 5449471387345524530L;

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private Integer pessoa;
	private Integer cidade;

	@Override
	public void copyFromEntity(Endereco entity) {
		this.id = entity.getId();
		this.logradouro = entity.getLogradouro();
		this.numero = entity.getNumero();
		this.complemento = entity.getComplemento();
		this.bairro = entity.getBairro();
		this.cep = entity.getCep();
		this.pessoa = entity.getPessoa().getId();
		this.cidade = entity.getCidade().getId();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getPessoa() {
		return pessoa;
	}

	public void setPessoa(Integer pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

}
