package com.br.carlos.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value = "/{id}",produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Pessoa pesquisaPorID(@PathVariable(value = "id") Long id) throws Exception {
		
		return pessoaService.findById(id);
	}
	
	@GetMapping(value = "/userAll",produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Pessoa> pesquisaAll(){
		
		return (List<Pessoa>) pessoaService.findall();
	}
	
	@PostMapping(value = "/cadPessoa",
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Pessoa cadastrarPessoa(@RequestBody Pessoa usuario ) throws Exception{
		
		return pessoaService.cadastrar(usuario);	
	}
	
	@PutMapping(value = "/atuPessoa",
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Pessoa atualizarPessoa(@RequestBody Pessoa usuario ) throws Exception{
		
		return pessoaService.atualizar(usuario);	
	}
	

	@DeleteMapping(value = "excPessoa/{id}")
	public ResponseEntity<?> Excluir(@PathVariable(value = "id") Long id) throws Exception {
		
		pessoaService.excluir(id);	
		return ResponseEntity.noContent().build();
	}
	

}

