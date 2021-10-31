package com.dallan.petshop.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dallan.petshop.domain.AbstractEntity;
import com.dallan.petshop.repositories.AbstractRepository;
import com.dallan.petshop.services.AbstractService;

public abstract class AbstractResource<E extends AbstractEntity<ID>, ID, R extends AbstractRepository<E, ID>, S extends AbstractService<E, ID, R>> {

	@Autowired
	protected S service;

	public abstract E copyAtributosParaUpdate(E obj, E other);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<E> find(@PathVariable ID id) {

		E obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<E> insert(@RequestBody E obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody E obj, @PathVariable ID id) {
		E found = service.find(id);

		found = copyAtributosParaUpdate(found, obj);

		found = service.update(found);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable ID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
