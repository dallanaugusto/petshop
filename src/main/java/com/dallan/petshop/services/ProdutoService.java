package com.dallan.petshop.services;

import org.springframework.stereotype.Service;

import com.dallan.petshop.domain.Produto;
import com.dallan.petshop.repositories.ProdutoRepository;

@Service
public class ProdutoService extends AbstractService<Produto, Integer, ProdutoRepository> {

}
