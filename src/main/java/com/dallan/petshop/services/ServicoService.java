package com.dallan.petshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dallan.petshop.domain.Servico;
import com.dallan.petshop.repositories.ServicoRepository;
import com.dallan.petshop.services.exceptions.DataIntegrityException;
import com.dallan.petshop.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repo;

	public Servico find(Integer id) {
		Optional<Servico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(id, Servico.class));
	}

	public Servico insert(Servico obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Servico update(Servico obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Servico não pode ser removida.");
		}
	}

}
