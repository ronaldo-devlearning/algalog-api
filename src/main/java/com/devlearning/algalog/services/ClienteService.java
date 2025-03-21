package com.devlearning.algalog.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devlearning.algalog.domain.Cliente;
import com.devlearning.algalog.exceptions.NegocioException;
import com.devlearning.algalog.repositories.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long clienteId) {
		
		return clienteRepository.findById(clienteId)
				.orElseThrow(()-> new NegocioException("Cliente não encontrado"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com esse e-mail!");
		}
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
}
