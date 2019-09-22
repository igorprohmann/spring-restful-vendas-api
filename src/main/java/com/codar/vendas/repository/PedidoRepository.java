package com.codar.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codar.vendas.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
