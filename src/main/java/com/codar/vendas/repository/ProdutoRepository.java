package com.codar.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codar.vendas.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
