package com.br.carlos.controller;

import java.awt.PageAttributes.MediaType;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.carlos.model.Pessoa;
import com.br.carlos.services.PessoaService;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	PessoaService pessoaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Pessoa pesquisaPorID(@PathVariable(value = "id") String id) throws Exception {
		
		return pessoaService.findById(id);
	}
	
	@RequestMapping(value = "/userAll", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Pessoa> pesquisaAll(){
		
		return (List<Pessoa>) pessoaService.findall();
	}
	
	@RequestMapping(value = "/cadPessoa", method = RequestMethod.POST,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Pessoa cadastrarPessoa(@RequestBody Pessoa usuario ) throws Exception{
		
		return pessoaService.cadastrar(usuario);	
	}
	
	@RequestMapping(value = "/atuPessoa", method = RequestMethod.PUT,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Pessoa atualizarPessoa(@RequestBody Pessoa usuario ) throws Exception{
		
		return pessoaService.atualizar(usuario);	
	}
	

	@RequestMapping(value = "excPessoa/{id}", method = RequestMethod.DELETE)
	public void Excluir(@PathVariable(value = "id") String id) throws Exception {
		
		pessoaService.excluir(id);	
	}

}

