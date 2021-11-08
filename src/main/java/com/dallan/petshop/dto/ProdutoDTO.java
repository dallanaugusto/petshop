package com.dallan.petshop.dto;

import java.util.ArrayList;
import java.util.List;

import com.dallan.petshop.domain.Categoria;
import com.dallan.petshop.domain.Produto;

public class ProdutoDTO extends AbstractDTO<Produto, Integer> {

	private static final long serialVersionUID = -3585376030285362130L;

	private String nome;
	private Double preco;
	private List<Integer> categorias;

	@Override
	public void copyFromEntity(Produto entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.preco = entity.getPreco();

		if (entity.getCategorias() != null) {
			this.categorias = new ArrayList<>();

			for (Categoria categoria : entity.getCategorias()) {
				this.categorias.add(categoria.getId());
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Integer> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Integer> categorias) {
		this.categorias = categorias;
	}

}
