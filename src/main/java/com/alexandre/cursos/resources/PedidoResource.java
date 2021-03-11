package com.alexandre.cursos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.cursos.services.PedidoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/pedidos")

public class PedidoResource {

	@Autowired
	private PedidoService pedido;
	
	@RequestMapping(value ="/{Id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer Id) {
	
	Object obj = pedido.find(Id);
		return ResponseEntity.ok().body(obj);
	}
	
}
