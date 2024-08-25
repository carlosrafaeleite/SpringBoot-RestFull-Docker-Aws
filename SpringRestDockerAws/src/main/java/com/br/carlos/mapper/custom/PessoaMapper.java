package com.br.carlos.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.br.carlos.data.vo.v2.PessoaVo2;
import com.br.carlos.model.Pessoa;

@Service
public class PessoaMapper {

	public PessoaVo2 converteEntityParaVo2(Pessoa pessoa) {

		PessoaVo2 pessoaVo2 = new PessoaVo2();
		pessoaVo2.setId(pessoa.getId());
		pessoaVo2.setNome(pessoa.getNome());
		pessoaVo2.setSobrenome(pessoa.getSobrenome());
		pessoaVo2.setSexo(pessoa.getSexo());
		pessoaVo2.setEndereco(pessoa.getEndereco());
		pessoaVo2.setDataAniversario(new Date());
		return pessoaVo2;
	}

	public Pessoa converteVOParaEntity(PessoaVo2 pessoaVo2) {

		Pessoa pessoa = new Pessoa();
		pessoa.setId(pessoaVo2.getId());
		pessoa.setNome(pessoaVo2.getNome());
		pessoa.setSobrenome(pessoaVo2.getSobrenome());
		pessoa.setSexo(pessoaVo2.getSexo());
		pessoa.setEndereco(pessoaVo2.getEndereco());
		return pessoa;
	}
}
