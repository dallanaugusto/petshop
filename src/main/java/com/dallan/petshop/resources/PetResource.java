package com.dallan.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Pet;
import com.dallan.petshop.dto.PetDTO;
import com.dallan.petshop.repositories.PetRepository;
import com.dallan.petshop.services.EspecieService;
import com.dallan.petshop.services.PetService;
import com.dallan.petshop.services.RacaService;

@RestController
@RequestMapping(value = "/pets")
public class PetResource extends AbstractResource<Pet, Integer, PetDTO, PetRepository, PetService> {

	@Autowired
	private EspecieService especieService;

	@Autowired
	private RacaService racaService;

	@Override
	public Pet makeEntityFromDTO(PetDTO dto) {
		return new Pet(dto.getId(), dto.getNome(), dto.getIdade(), especieService.find(dto.getEspecie()),
				racaService.find(dto.getRaca()));
	}

	@Override
	public Pet mergeDTOIntoEntity(PetDTO dto, Pet entity) {
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setIdade(dto.getIdade());
		entity.setEspecie(especieService.find(dto.getEspecie()));
		entity.setRaca(racaService.find(dto.getRaca()));
		return entity;
	}

}
