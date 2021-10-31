package com.dallan.petshop.repositories;

import org.springframework.stereotype.Repository;

import com.dallan.petshop.domain.Especie;

@Repository
public interface EspecieRepository extends AbstractRepository<Especie, Integer> {

}
