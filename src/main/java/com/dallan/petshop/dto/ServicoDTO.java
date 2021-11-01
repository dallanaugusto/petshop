package com.dallan.petshop.dto;

import java.util.Date;

import com.dallan.petshop.domain.Servico;

public class ServicoDTO extends AbstractDTO<Servico, Integer> {

	private static final long serialVersionUID = 5085711660845728216L;

	private Date dataEntrada;
	private Date dataSaida;
	private String descricao;
	private Integer pagamento;
	private Integer cliente;
	private Integer funcionario;
	private Integer pet;

	@Override
	public void copyFromEntity(Servico entity) {
		this.id = entity.getId();
		this.dataEntrada = entity.getDataEntrada();
		this.dataSaida = entity.getDataSaida();
		this.descricao = entity.getDescricao();
		this.pagamento = entity.getPagamento().getId();
		this.cliente = entity.getCliente().getId();
		this.funcionario = entity.getFuncionario().getId();
		this.pet = entity.getPet().getId();
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPagamento() {
		return pagamento;
	}

	public void setPagamento(Integer pagamento) {
		this.pagamento = pagamento;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getPet() {
		return pet;
	}

	public void setPet(Integer pet) {
		this.pet = pet;
	}

}
