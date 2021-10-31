package com.dallan.petshop.services;

import org.springframework.stereotype.Service;

import com.dallan.petshop.domain.Pagamento;
import com.dallan.petshop.repositories.PagamentoRepository;

@Service
public class PagamentoService extends AbstractService<Pagamento, Integer, PagamentoRepository> {

}
