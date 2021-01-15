package com.alexandre.cursos.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/categorias")
@Controller
public class CategoriaResources {

	@RequestMapping(method=RequestMethod.GET)
	public String listar() {

		return "Rest esta funcionando";
	}
}