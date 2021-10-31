package com.dallan.petshop.repositories;

import org.springframework.stereotype.Repository;

import com.dallan.petshop.domain.Produto;

@Repository
public interface ProdutoRepository extends AbstractRepository<Produto, Integer> {

}
