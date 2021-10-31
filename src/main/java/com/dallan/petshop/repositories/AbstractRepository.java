package com.dallan.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.dallan.petshop.domain.AbstractEntity;

@NoRepositoryBean
public abstract interface AbstractRepository<E extends AbstractEntity<ID>, ID> extends JpaRepository<E, ID> {

}
