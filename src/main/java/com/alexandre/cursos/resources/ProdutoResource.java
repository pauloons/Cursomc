package com.alexandre.cursos.resources;

import com.alexandre.cursos.domain.Categoria;
import com.alexandre.cursos.domain.Produto;
import com.alexandre.cursos.dto.CategoriaDTO;
import com.alexandre.cursos.dto.ProdutoDTO;
import com.alexandre.cursos.resources.utils.Url;
import com.alexandre.cursos.services.PedidoService;
import com.alexandre.cursos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")

public class ProdutoResource {

	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value ="/{Id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer Id) {
	
	Object obj = service.find(Id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value="nome", defaultValue="") String nome,
			@RequestParam(value="categorias", defaultValue="") String categorias,
			@RequestParam(value="page", defaultValue="0") String page,
			@RequestParam(value="linesPerPage", defaultValue="24") String linesPerPage,
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		List<Integer>Ids = Url.decodeIntList(categorias);
		Page<Produto> list = service.search(???,Ids,page, linesPerPage, orderBy, direction);
		Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
