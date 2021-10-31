package com.dallan.petshop.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Pessoa;
import com.dallan.petshop.dto.PessoaDTO;
import com.dallan.petshop.repositories.PessoaRepository;
import com.dallan.petshop.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource extends AbstractResource<Pessoa, Integer, PessoaRepository, PessoaService> {

	@Override
	public Pessoa copyAtributosParaUpdate(Pessoa obj, Pessoa other) {
		obj.setNome(other.getNome());
		obj.setEmail(other.getEmail());
		obj.setCodNacional(other.getCodNacional());
		obj.setTelefones(other.getTelefones());

		return obj;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> findAll() {
		List<Pessoa> lista = service.findAll();

		List<PessoaDTO> listaDTO = lista.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}

}
