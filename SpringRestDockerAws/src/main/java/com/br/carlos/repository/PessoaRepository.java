package com.br.carlos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.carlos.model.Pessoa;

//@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Long> {
	


}
