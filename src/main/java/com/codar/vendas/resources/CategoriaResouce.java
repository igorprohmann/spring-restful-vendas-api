package com.codar.vendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codar.vendas.domain.Categoria;
import com.codar.vendas.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResouce {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping()
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
}
