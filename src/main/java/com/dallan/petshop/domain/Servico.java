package com.dallan.petshop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Servico extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -8247429404840097790L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataEntrada;
	private Date dataSaida;
	private String descricao;

	@OneToOne(mappedBy = "servico", cascade = CascadeType.ALL)
	private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "id_pet")
	private Pet pet;

	@ManyToMany
	@JoinTable(name = "SERVICO_PRODUTO", joinColumns = @JoinColumn(name = "id_servico"), inverseJoinColumns = @JoinColumn(name = "id_produto"))
	private List<Produto> produtos = new ArrayList<>();

	public Servico() {
		super();
	}

	public Servico(Integer id, Date dataEntrada, Date dataSaida, String descricao, Cliente cliente,
			Funcionario funcionario) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.descricao = descricao;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public Servico(Integer id, Date dataEntrada, Date dataSaida, String descricao, Cliente cliente,
			Funcionario funcionario, Pet pet) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.descricao = descricao;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.pet = pet;
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
		Servico other = (Servico) obj;
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

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
