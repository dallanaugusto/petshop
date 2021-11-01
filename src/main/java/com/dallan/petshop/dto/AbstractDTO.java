package com.dallan.petshop.dto;

import java.io.Serializable;

import com.dallan.petshop.domain.AbstractEntity;

public abstract class AbstractDTO<E extends AbstractEntity<ID>, ID> implements Serializable {

	private static final long serialVersionUID = 2908007482627482921L;

	protected ID id;

	public AbstractDTO() {

	}

	public abstract void copyFromEntity(E entity);

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

}
