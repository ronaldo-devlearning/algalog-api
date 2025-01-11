package com.devlearning.algalog.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devlearning.algalog.assembler.EntregaAssembler;
import com.devlearning.algalog.domain.Entrega;
import com.devlearning.algalog.dtos.EntregaDTO;
import com.devlearning.algalog.input.EntregaInput;
import com.devlearning.algalog.repositories.EntregaRepository;
import com.devlearning.algalog.services.FinalizacaoEntregaService;
import com.devlearning.algalog.services.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaResource {

	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private EntregaAssembler entregaAssembler;
	private FinalizacaoEntregaService finalizacaoEntregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
		Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
		
		return entregaAssembler.toDTO(entregaSolicitada);
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		
		finalizacaoEntregaService.finalizar(entregaId);
		
	}
	
	@GetMapping
	public List<EntregaDTO> listar(){
		return entregaAssembler.toCollectionDTO(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId){
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toDTO(entrega)))
				.orElse(ResponseEntity.notFound().build());				
	}
	
}