package com.br.carlos.services;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.carlos.data.vo.v1.PessoaVo;
import com.br.carlos.exceptions.ResourseNotFoundException;
import com.br.carlos.repository.PessoaRepository;

@Service
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	PessoaRepository pessoaRepository;

	private Logger logger = Logger.getLogger(PessoaService.class.getName());

	public PessoaVo findById(Long id) {

		logger.info("PessoaVo aqui");
		return pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));

	}

	public List<PessoaVo> findall() {

		logger.info("PessoaVo aqui All");
		return pessoaRepository.findAll();
	}

	public PessoaVo cadastrar(PessoaVo pessoa) {
		logger.info("cadastrando PessoaVo");
		return pessoaRepository.save(pessoa);
	}

	public PessoaVo atualizar(PessoaVo pessoa) {

		var entity = pessoaRepository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));

		entity.setNome(pessoa.getNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setSexo(pessoa.getSexo());
		logger.info("atualizando PessoaVo aqui");

		return pessoaRepository.save(entity);
	}

	public void excluir(Long id) {

		PessoaVo entity = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));

		pessoaRepository.delete(entity);
		logger.info("excluindo PessoaVo aqui");

	}

}
