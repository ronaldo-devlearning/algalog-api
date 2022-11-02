package com.devlearning.algalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devlearning.algalog.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNome(String nome);
	List<Cliente> findByNomeContaining(String nome);
	
}
