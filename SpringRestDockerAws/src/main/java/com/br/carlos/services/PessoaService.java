package com.br.carlos.services;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.carlos.exceptions.ResourseNotFoundException;
import com.br.carlos.model.Pessoa;
import com.br.carlos.repository.PessoaRepository;

@Service
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	PessoaRepository pessoaRepository;

	private Logger logger = Logger.getLogger(PessoaService.class.getName());

	public Pessoa findById(Long id) {

		logger.info("Pessoa aqui");
		return pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));

	}

	public List<Pessoa> findall() {

		logger.info("Pessoa aqui All");
		return pessoaRepository.findAll();
	}

	public Pessoa cadastrar(Pessoa pessoa) {
		logger.info("cadastrando Pessoa");
		return pessoaRepository.save(pessoa);
	}

	public Pessoa atualizar(Pessoa pessoa) {

		var entity = pessoaRepository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));

		entity.setNome(pessoa.getNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setSexo(pessoa.getSexo());
		logger.info("atualizando Pessoa aqui");

		return pessoaRepository.save(entity);
	}

	public void excluir(Long id) {

		Pessoa entity = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));

		pessoaRepository.delete(entity);
		logger.info("excluindo Pessoa aqui");

	}

}
