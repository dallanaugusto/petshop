package com.dallan.petshop.repositories;

import org.springframework.stereotype.Repository;

import com.dallan.petshop.domain.Pessoa;

@Repository
public interface PessoaRepository extends AbstractRepository<Pessoa, Integer> {

}
