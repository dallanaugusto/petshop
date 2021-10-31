package com.dallan.petshop.services;

import org.springframework.stereotype.Service;

import com.dallan.petshop.domain.Categoria;
import com.dallan.petshop.repositories.CategoriaRepository;

@Service
public class CategoriaService extends AbstractService<Categoria, Integer, CategoriaRepository> {

}
