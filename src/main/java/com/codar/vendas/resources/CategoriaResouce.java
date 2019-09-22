package com.codar.vendas.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codar.vendas.domain.Categoria;
import com.codar.vendas.services.CategoriaService;


@RestController
@RequestMapping("/categorias")
public class CategoriaResouce {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> obter(@PathVariable("id") Integer id) {
		Categoria categoria = categoriaService.obter(id);
		
		return ResponseEntity.ok().body(categoria);
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Categoria categoria){
		categoria = categoriaService.inserir(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Categoria categoria, @PathVariable("id") Integer id) {
		categoria.setId(id);
		categoria = categoriaService.atualizar(categoria);
		return ResponseEntity.noContent().build();
	}

}
