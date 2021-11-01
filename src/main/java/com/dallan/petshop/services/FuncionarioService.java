package com.dallan.petshop.services;

import org.springframework.stereotype.Service;

import com.dallan.petshop.domain.Funcionario;
import com.dallan.petshop.repositories.FuncionarioRepository;

@Service
public class FuncionarioService extends AbstractService<Funcionario, Integer, FuncionarioRepository> {

}
