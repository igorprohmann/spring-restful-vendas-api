package com.codar.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codar.vendas.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
