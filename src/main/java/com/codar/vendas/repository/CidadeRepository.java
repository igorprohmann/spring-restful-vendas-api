package com.codar.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codar.vendas.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
