package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Pet;
import com.dallan.petshop.repositories.PetRepository;
import com.dallan.petshop.services.PetService;

@RestController
@RequestMapping(value = "/pets")
public class PetResource extends AbstractResource<Pet, Integer, PetRepository, PetService> {

	@Override
	public Pet copyAtributosParaUpdate(Pet obj, Pet other) {
		obj.setNome(other.getNome());
		obj.setIdade(other.getIdade());
		obj.setEspecie(other.getEspecie());
		obj.setRaca(other.getRaca());

		return obj;
	}

}
