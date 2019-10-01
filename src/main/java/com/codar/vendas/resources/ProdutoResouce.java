package com.codar.vendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codar.vendas.domain.Produto;
import com.codar.vendas.dto.ProdutoDTO;
import com.codar.vendas.resources.utils.URL;
import com.codar.vendas.services.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoResouce {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> find(@PathVariable("id") Integer id) {
		Produto produto = produtoService.obter(id);
		
		return ResponseEntity.ok().body(produto);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<ProdutoDTO>> listarPagina(
			@RequestParam(value = "nome", defaultValue = "") String nome, 
			@RequestParam(value = "categorias", defaultValue = "") String categorias, 
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "ordeBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Produto> produtos = produtoService.buscar(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoDTO> produtosDTO = produtos.map(produto -> new ProdutoDTO(produto));
		return ResponseEntity.ok().body(produtosDTO);
	}
}
