package com.codar.vendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codar.vendas.domain.Categoria;
import com.codar.vendas.repository.CategoriaRepository;
import com.codar.vendas.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria obter(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria inserir(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}
	
	public Categoria atualizar(Categoria categoria) {
		obter(categoria.getId());
		return categoriaRepository.save(categoria);
	}
}
