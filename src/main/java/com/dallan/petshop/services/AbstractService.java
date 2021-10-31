package com.dallan.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.dallan.petshop.domain.AbstractEntity;
import com.dallan.petshop.repositories.AbstractRepository;
import com.dallan.petshop.services.exceptions.DataIntegrityException;
import com.dallan.petshop.services.exceptions.ObjetoNaoEncontradoException;
import com.dallan.petshop.utils.ReflectUtil;

public abstract class AbstractService<E extends AbstractEntity<ID>, ID, R extends AbstractRepository<E, ID>> {

	@Autowired
	protected R repo;

	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() {
		Class<E> entityClass = (Class<E>) ReflectUtil.getParameterClassFromParameterizedClass(getClass(), 0);
		return entityClass;
	}

	public E find(ID id) {
		Optional<E> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException((Integer) id, getEntityClass()));
	}

	public E insert(E obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public E update(E obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(ID id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover");
		}
	}

	public List<E> findAll() {
		return repo.findAll();
	}

}
