package com.dallan.petshop.repositories;

import org.springframework.stereotype.Repository;

import com.dallan.petshop.domain.Categoria;

@Repository
public interface CategoriaRepository extends AbstractRepository<Categoria, Integer> {

}
