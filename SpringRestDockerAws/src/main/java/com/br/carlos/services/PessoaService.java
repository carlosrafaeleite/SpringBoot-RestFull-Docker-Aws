package com.br.carlos.services;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.carlos.data.vo.v1.PessoaVo;
import com.br.carlos.data.vo.v2.PessoaVo2;
import com.br.carlos.exceptions.ResourseNotFoundException;
import com.br.carlos.mapper.DozerMapper;
import com.br.carlos.model.Pessoa;
import com.br.carlos.repository.PessoaRepository;

@Service
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	PessoaRepository pessoaRepository;

	private Logger logger = Logger.getLogger(PessoaService.class.getName());

	public PessoaVo findById(Long id) {

		logger.info("PessoaVo aqui");
		var entyty = pessoaRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));
		return DozerMapper.parseObject(entyty, PessoaVo.class);
	}

	public List<PessoaVo> findall() {

		logger.info("PessoaVo aqui All");
		// return pessoaRepository.findAll();
		return DozerMapper.parseListObjects(pessoaRepository.findAll(), PessoaVo.class);
	}

	public PessoaVo cadastrar(PessoaVo pessoa) {
		logger.info("cadastrando PessoaVo");
		
		var entyty = DozerMapper.parseObject(pessoa, Pessoa.class);
		var vo = DozerMapper.parseObject(pessoaRepository.save(entyty), PessoaVo.class);
		return vo;
	}
	
	public PessoaVo2 cadastrarV2(PessoaVo2 pessoa) {
		logger.info("cadastrando PessoaVo");
		
		var entyty = DozerMapper.parseObject(pessoa, Pessoa.class);
		var vo2 = DozerMapper.parseObject(pessoaRepository.save(entyty), PessoaVo2.class);
		return vo2;
	}

	public PessoaVo atualizar(PessoaVo pessoa) {

		var entity = pessoaRepository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));

		entity.setNome(pessoa.getNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setSexo(pessoa.getSexo());
		logger.info("atualizando PessoaVo aqui");

		var vo = DozerMapper.parseObject(pessoaRepository.save(entity), PessoaVo.class);
		return vo;
		
	}

	public void excluir(Long id) {

		var entity = pessoaRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));

		pessoaRepository.delete(entity);
		logger.info("excluindo PessoaVo aqui");

	}

}
