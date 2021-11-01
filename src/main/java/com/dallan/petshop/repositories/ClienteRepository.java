package com.dallan.petshop.repositories;

import org.springframework.stereotype.Repository;

import com.dallan.petshop.domain.Cliente;

@Repository
public interface ClienteRepository extends AbstractRepository<Cliente, Integer> {

}
