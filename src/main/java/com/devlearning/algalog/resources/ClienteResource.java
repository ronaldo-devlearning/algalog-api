package com.devlearning.algalog.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devlearning.algalog.domain.Cliente;

@RestController
public class ClienteResource {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		Cliente cliente1 = new Cliente(1L, "Maria","maria@gmail.com", "99999999");
		Cliente cliente2 = new Cliente(2L, "José","jose@gmail.com", "988888888");

		return Arrays.asList(cliente1, cliente2);
	}
}
