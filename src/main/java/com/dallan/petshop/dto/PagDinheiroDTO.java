package com.dallan.petshop.dto;

import java.util.Date;

import com.dallan.petshop.domain.PagDinheiro;

public class PagDinheiroDTO extends AbstractDTO<PagDinheiro, Integer> {

	private static final long serialVersionUID = 3724399163686037073L;

	private Date dataVencimento;
	private Double desconto;
	private Integer pagamento;

	@Override
	public void copyFromEntity(PagDinheiro entity) {
		this.id = entity.getId();
		this.dataVencimento = entity.getDataVencimento();
		this.desconto = entity.getDesconto();
		this.setPagamento(entity.getPagamento().getId());
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getPagamento() {
		return pagamento;
	}

	public void setPagamento(Integer pagamento) {
		this.pagamento = pagamento;
	}

}
