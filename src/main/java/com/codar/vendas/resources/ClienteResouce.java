package com.codar.vendas.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codar.vendas.domain.Cliente;
import com.codar.vendas.services.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteResouce {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> find(@PathVariable("id") Integer id) {
		Cliente cliente = clienteService.obter(id);
		
		return ResponseEntity.ok().body(cliente);
	}
}
