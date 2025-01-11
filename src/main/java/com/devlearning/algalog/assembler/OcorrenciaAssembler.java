package com.devlearning.algalog.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devlearning.algalog.domain.Ocorrencia;
import com.devlearning.algalog.dtos.OcorrenciaDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

	private ModelMapper modelMapper;
	
	public OcorrenciaDTO toDTO(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
	}
	
	public List<OcorrenciaDTO> toCollectionDTO(List<Ocorrencia> ocorrencias){
		
		return ocorrencias.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}
	
}