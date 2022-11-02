package com.devlearning.algalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devlearning.algalog.domain.Cliente;
import com.devlearning.algalog.repositories.ClienteRepository;

@RestController
public class ClienteResource {

	@Autowired
	private ClienteRepository clienteRepository;
	
	/*@PersistenceContext
	private EntityManager manager;*/
	
	/*@GetMapping("/clientes")
	public List<Cliente> listar() {
		return manager.createQuery("from Cliente", Cliente.class)
				.getResultList();
	}*/
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		//return clienteRepository.findByNomeContaining("o");
		//return clienteRepository.findBynome("Jose");
		return clienteRepository.findAll();
	}
}
