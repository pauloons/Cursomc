package com.alexandre.cursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.alexandre.cursos.domain.Categoria;
import com.alexandre.cursos.dto.CategoriaDTO;
import com.alexandre.cursos.repositories.CategoriaRepository;
import com.alexandre.cursos.services.exeptions.DataIntegrityException;
import com.alexandre.cursos.services.exeptions.ObjectNotFoundExeption;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll()  {
		return repo.findAll();
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}


	public Categoria update(Categoria obj)  {
		Categoria newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}

	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}

	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
	}catch (DataIntegrityViolationException e) {
		throw new DataIntegrityException("Não é possivel excluir uma categoria sem pedido");
	}
}
public Page<Categoria> findPage(Integer page, Integer linesPerPage,String OrderBy, String direction){
	PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction), OrderBy);
	return repo.findAll(pageRequest);
}
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}

}