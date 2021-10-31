package com.dallan.petshop.services;

import org.springframework.stereotype.Service;

import com.dallan.petshop.domain.Pessoa;
import com.dallan.petshop.repositories.PessoaRepository;

@Service
public class PessoaService extends AbstractService<Pessoa, Integer, PessoaRepository> {

}
