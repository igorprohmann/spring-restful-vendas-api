package com.codar.vendas.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codar.vendas.domain.Pedido;
import com.codar.vendas.services.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoResouce {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> find(@PathVariable("id") Integer id) {
		Pedido pedido = pedidoService.obter(id);
		
		return ResponseEntity.ok().body(pedido);
	}
}
