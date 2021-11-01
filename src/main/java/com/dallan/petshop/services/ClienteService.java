package com.dallan.petshop.services;

import org.springframework.stereotype.Service;

import com.dallan.petshop.domain.Cliente;
import com.dallan.petshop.repositories.ClienteRepository;

@Service
public class ClienteService extends AbstractService<Cliente, Integer, ClienteRepository> {

}
