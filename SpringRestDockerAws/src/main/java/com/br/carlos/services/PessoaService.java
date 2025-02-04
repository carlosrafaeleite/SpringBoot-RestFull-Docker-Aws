package com.br.carlos.services;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.br.carlos.controller.PessoaController;
import com.br.carlos.data.vo.v1.PessoaVo;
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

	public PessoaVo findById(Long id) throws Exception {

		logger.info("PessoaVo aqui");
		var entyty = pessoaRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));
		var vo = DozerMapper.parseObject(entyty, PessoaVo.class);
		vo.add(linkTo(methodOn(PessoaController.class).pesquisaPorID(id)).withSelfRel());
		return vo;
	}

	public List<PessoaVo> findall() {

		logger.info("PessoaVo aqui All");
		// return pessoaRepository.findAll();
		//return DozerMapper.parseListObjects(pessoa	Repository.findAll(), PessoaVo.class);
		var person =  DozerMapper.parseListObjects(pessoaRepository.findAll(), PessoaVo.class);
		person.stream().forEach(p -> {
			try {
				p.add((linkTo(methodOn(PessoaController.class).pesquisaPorID(p.getKey()))).withSelfRel());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return person;
		
	}

	public PessoaVo cadastrar(PessoaVo pessoa) throws Exception {
		logger.info("cadastrando PessoaVo");
		
		var entyty = DozerMapper.parseObject(pessoa, Pessoa.class);
		var vo = DozerMapper.parseObject(pessoaRepository.save(entyty), PessoaVo.class);
		vo.add(linkTo(methodOn(PessoaController.class).pesquisaPorID(vo.getKey())).withSelfRel());
		return vo;

	}
	
	
	public PessoaVo atualizar(PessoaVo pessoa) throws Exception {

		var entity = pessoaRepository.findById(pessoa.getKey())
				.orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));

		entity.setNome(pessoa.getNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setSexo(pessoa.getSexo());
		logger.info("atualizando PessoaVo aqui");

		var vo = DozerMapper.parseObject(pessoaRepository.save(entity), PessoaVo.class);
		vo.add(linkTo(methodOn(PessoaController.class).pesquisaPorID(vo.getKey())).withSelfRel());
		return vo;
		
	}

	public void excluir(Long id) {

		var entity = pessoaRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Registro nao encontrado"));

		pessoaRepository.delete(entity);
		logger.info("excluindo PessoaVo aqui");

	}

}
