package com.dallan.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dallan.petshop.domain.Pessoa;
import com.dallan.petshop.repositories.PessoaRepository;
import com.dallan.petshop.services.exceptions.DataIntegrityException;
import com.dallan.petshop.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(id, Pessoa.class));
	}

	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Pessoa update(Pessoa obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Pessoa não pode ser removida.");
		}
	}

	public List<Pessoa> findAll() {
		return repo.findAll();
	}

}
