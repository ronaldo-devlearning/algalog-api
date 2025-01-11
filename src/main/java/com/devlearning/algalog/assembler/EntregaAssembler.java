package com.devlearning.algalog.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devlearning.algalog.domain.Entrega;
import com.devlearning.algalog.dtos.EntregaDTO;
import com.devlearning.algalog.input.EntregaInput;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {

	private ModelMapper modelMapper;
	
	public EntregaDTO toDTO(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDTO.class);
	}

	public List<EntregaDTO> toCollectionDTO(List<Entrega> entregas){
		return entregas.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
	
}