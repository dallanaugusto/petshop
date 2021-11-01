package com.dallan.petshop.repositories;

import org.springframework.stereotype.Repository;

import com.dallan.petshop.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends AbstractRepository<Funcionario, Integer> {

}
