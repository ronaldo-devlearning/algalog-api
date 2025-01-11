package com.devlearning.algalog.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devlearning.algalog.assembler.OcorrenciaAssembler;
import com.devlearning.algalog.domain.Entrega;
import com.devlearning.algalog.domain.Ocorrencia;
import com.devlearning.algalog.dtos.OcorrenciaDTO;
import com.devlearning.algalog.input.OcorrenciaInput;
import com.devlearning.algalog.services.BuscarEntregaService;
import com.devlearning.algalog.services.RegistroOcorrenciaService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaResource {

	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAssembler;
	private BuscarEntregaService buscarEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDTO registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
				.registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return ocorrenciaAssembler.toDTO(ocorrenciaRegistrada);
		
	}
	
	@GetMapping
	public List<OcorrenciaDTO> listar(@PathVariable Long entregaId){
		
		Entrega entrega = buscarEntregaService.buscar(entregaId);
		
		return ocorrenciaAssembler.toCollectionDTO(entrega.getOcorrencias());
	}
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	
}