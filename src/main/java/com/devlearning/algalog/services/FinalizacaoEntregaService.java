package com.devlearning.algalog.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devlearning.algalog.domain.Entrega;
import com.devlearning.algalog.repositories.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

	private EntregaRepository entregaRepository;
	private BuscarEntregaService buscarEntregaService;
	
	@Transactional
	public void finalizar(Long entregaId) {
		
		Entrega entrega = buscarEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
		
	}
}