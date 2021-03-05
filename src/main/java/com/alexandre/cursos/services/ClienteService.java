package com.alexandre.cursos.services;

import java.util.List;
import java.util.Optional;

import com.alexandre.cursos.domain.Cidade;
import com.alexandre.cursos.domain.Cliente;
import com.alexandre.cursos.domain.Endereco;
import com.alexandre.cursos.domain.enums.Tipo_Cliente;
import com.alexandre.cursos.dto.ClienteDTO;
import com.alexandre.cursos.dto.ClienteNewDTO;
import com.alexandre.cursos.repositories.CidadeRepository;
import com.alexandre.cursos.services.exeptions.DataIntegridyExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.alexandre.cursos.repositories.ClienteRepository;
import com.alexandre.cursos.repositories.EnderecoRepository;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.TransactionScoped;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;


	public Cliente find(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

/*
Dessa forma inclui apenas o cliente sem o endereço é preciso fazer alterações no cliente service
*/
/*	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}*/


	public Cliente update(Cliente obj) throws ObjectNotFoundException {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegridyExeption("Não é possivel excluir uma Cliente sem pedido");
		}
	}



	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String OrderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), OrderBy);
		return repo.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}

	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), Tipo_Cliente.toEnum(objDto.getTipo()));
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogadouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(),
				objDto.getCep(), cid, cli);
		cli.getEnderecos().add(end);
		return cli;
	}
}

