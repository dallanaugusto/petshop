package com.dallan.petshop.domain;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractEntity<ID> implements Serializable {

	private static final long serialVersionUID = 3098718694570608950L;

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity<ID> other = (AbstractEntity<ID>) obj;
		return Objects.equals(getId(), other.getId());
	}

	public abstract ID getId();

	public abstract void setId(ID id);

}
