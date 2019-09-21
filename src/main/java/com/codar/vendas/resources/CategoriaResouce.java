package com.codar.vendas.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codar.vendas.domain.Categoria;
import com.codar.vendas.services.CategoriaService;


@RestController
@RequestMapping("/categorias")
public class CategoriaResouce {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> find(@PathVariable("id") Integer id) {
		Categoria categoria = categoriaService.obter(id);
		
		return ResponseEntity.ok().body(categoria);
	}
}
