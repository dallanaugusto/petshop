package com.dallan.petshop.resources;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dallan.petshop.domain.AbstractEntity;
import com.dallan.petshop.dto.AbstractDTO;
import com.dallan.petshop.repositories.AbstractRepository;
import com.dallan.petshop.services.AbstractService;
import com.dallan.petshop.utils.ReflectUtil;

public abstract class AbstractResource<E extends AbstractEntity<ID>, ID, DTO extends AbstractDTO<E, ID>, R extends AbstractRepository<E, ID>, S extends AbstractService<E, ID, R>> {

	@Autowired
	protected S service;

	public abstract E makeEntityFromDTO(DTO dto);

	public abstract E mergeDTOIntoEntity(DTO dto, E entity);

	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() {
		Class<E> entityClass = (Class<E>) ReflectUtil.getParameterClassFromParameterizedClass(getClass(), 0);
		return entityClass;
	}

	@SuppressWarnings("unchecked")
	public Class<DTO> getDTOClass() {
		Class<DTO> entityClass = (Class<DTO>) ReflectUtil.getParameterClassFromParameterizedClass(getClass(), 2);
		return entityClass;
	}

	public Constructor<DTO> getDTOContructor() {
		try {
			return getDTOClass().getDeclaredConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	public DTO getDTOFromEntity(E entity) {
		try {
			DTO dto = getDTOContructor().newInstance();
			dto.copyFromEntity(entity);
			return dto;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DTO> find(@PathVariable ID id) {
		E entity = service.find(id);
		DTO dto = getDTOFromEntity(entity);
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<DTO> insert(@RequestBody DTO dto) {
		E entity = makeEntityFromDTO(dto);
		entity = service.insert(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody DTO dto, @PathVariable ID id) {
		E oldEntity = service.find(id);
		E entity = mergeDTOIntoEntity(dto, oldEntity);
		entity.setId(id);
		entity = service.update(entity);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable ID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DTO>> findAll() {
		List<E> lista = service.findAll();

		List<DTO> listaDTO = lista.stream().map(entity -> getDTOFromEntity(entity)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}

}
