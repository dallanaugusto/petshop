package com.dallan.petshop.repositories;

import org.springframework.stereotype.Repository;

import com.dallan.petshop.domain.Pet;

@Repository
public interface PetRepository extends AbstractRepository<Pet, Integer> {

}
