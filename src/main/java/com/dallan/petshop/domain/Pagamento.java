package com.dallan.petshop.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.dallan.petshop.domain.enums.SituacaoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pagamento extends AbstractEntity<Integer> {

	private static final long serialVersionUID = 757229768798441198L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer situacaoCod;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_servico")
	private Servico servico;

	public Pagamento() {
		super();
	}

	public Pagamento(Integer id, SituacaoPagamento situacao, Servico servico) {
		super();
		this.id = id;
		this.situacaoCod = situacao.getCod();
		this.servico = servico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public SituacaoPagamento getSituacao() {
		return SituacaoPagamento.toEnum(situacaoCod);
	}

	public void setSituacao(SituacaoPagamento situacao) {
		this.situacaoCod = situacao.getCod();
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}
