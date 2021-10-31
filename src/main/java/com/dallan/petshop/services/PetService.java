package com.dallan.petshop.services;

import org.springframework.stereotype.Service;

import com.dallan.petshop.domain.Pet;
import com.dallan.petshop.repositories.PetRepository;

@Service
public class PetService extends AbstractService<Pet, Integer, PetRepository> {

}
