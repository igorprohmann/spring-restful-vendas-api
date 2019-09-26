package com.codar.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codar.vendas.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
