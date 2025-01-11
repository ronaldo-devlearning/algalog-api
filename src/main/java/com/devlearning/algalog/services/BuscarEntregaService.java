package com.devlearning.algalog.services;

import org.springframework.stereotype.Service;

import com.devlearning.algalog.domain.Entrega;
import com.devlearning.algalog.exceptions.EntidadeNaoEncontradaException;
import com.devlearning.algalog.repositories.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscarEntregaService {

	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
		
	}
	
}