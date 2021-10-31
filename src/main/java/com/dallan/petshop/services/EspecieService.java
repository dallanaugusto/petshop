package com.dallan.petshop.services;

import org.springframework.stereotype.Service;

import com.dallan.petshop.domain.Especie;
import com.dallan.petshop.repositories.EspecieRepository;

@Service
public class EspecieService extends AbstractService<Especie, Integer, EspecieRepository> {

}
