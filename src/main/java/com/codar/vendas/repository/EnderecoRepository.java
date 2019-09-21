package com.codar.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codar.vendas.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
