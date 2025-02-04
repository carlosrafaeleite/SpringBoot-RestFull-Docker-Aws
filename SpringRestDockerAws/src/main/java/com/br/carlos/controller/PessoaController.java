package com.br.carlos.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.carlos.data.vo.v1.PessoaVo;
import com.br.carlos.services.PessoaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path ="/api/pessoa/v1")
@Tag(name = "Pessoas", description = "Controle de Clientes")
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,})
	@Operation(summary = "Listando Clientes", 
	description = "Listando Clientes", 
	tags = {"Pessoas"},
	responses = {
			@ApiResponse(description= "Sucesso", responseCode = "200", 
					content = @Content(schema = @Schema(implementation = PessoaVo.class))
			),
			@ApiResponse(description= "Sem Content", responseCode = "204", content = @Content), 
			@ApiResponse(description= "Falhou", responseCode = "400", content = @Content), 
			@ApiResponse(description= "Não autorizado", responseCode = "401", content = @Content), 
			@ApiResponse(description= "Página nao encontrada", responseCode = "404", content = @Content), 
			@ApiResponse(description= "Servidor não encontrado", responseCode = "500", content = @Content) 

})
	public PessoaVo pesquisaPorID(@PathVariable(value = "id") Long id) throws Exception {
		
		return pessoaService.findById(id);
	}
	
	@GetMapping(value = "/userAll",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "Listando Todos Clientes", 
				description = "Listando Todos Clientes", 
				tags = {"Pessoas"},
				responses = {
						@ApiResponse(description= "Sucesso", responseCode = "200", 
								content = {
									@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PessoaVo.class))
								)}),
						@ApiResponse(description= "Falhou", responseCode = "400", content = @Content), 
						@ApiResponse(description= "Não autorizado", responseCode = "401", content = @Content), 
						@ApiResponse(description= "Página nao encontrada", responseCode = "404", content = @Content), 
						@ApiResponse(description= "Servidor não encontrado", responseCode = "500", content = @Content) 
			
			})
	public List<PessoaVo> pesquisaAll(){
		
		return (List<PessoaVo>) pessoaService.findall();
	}
	
	@PostMapping(value = "/cadPessoa",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, } ,
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, })
	@Operation(summary = "Cadastrando Clientes", 
	description = "Cadastrando Clientes", 
	tags = {"Pessoas"},
	responses = {
			@ApiResponse(description= "Sucesso", responseCode = "200", 
					content = @Content(schema = @Schema(implementation = PessoaVo.class))
			),
			@ApiResponse(description= "Falhou", responseCode = "400", content = @Content), 
			@ApiResponse(description= "Não autorizado", responseCode = "401", content = @Content), 
			@ApiResponse(description= "Servidor não encontrado", responseCode = "500", content = @Content) 

})
	public PessoaVo cadastrarPessoa(@RequestBody PessoaVo usuario ) throws Exception{
		
		return pessoaService.cadastrar(usuario);	
	}
	

	@PutMapping(value = "/atuPessoa",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, },
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, })
	@Operation(summary = "Atualizando Cliente", 
	description = "Atualizando Cliente", 
	tags = {"Pessoas"},
	responses = {
			@ApiResponse(description= "Sucesso", responseCode = "200", 
					content = @Content(schema = @Schema(implementation = PessoaVo.class))
			),
			@ApiResponse(description= "Falhou", responseCode = "400", content = @Content), 
			@ApiResponse(description= "Não autorizado", responseCode = "401", content = @Content), 
			@ApiResponse(description= "Página nao encontrada", responseCode = "404", content = @Content), 
			@ApiResponse(description= "Servidor não encontrado", responseCode = "500", content = @Content) 

})
	public PessoaVo atualizarPessoa(@RequestBody PessoaVo usuario ) throws Exception{
		
		return pessoaService.atualizar(usuario);	
	}
	

	@DeleteMapping(value = "excPessoa/{id}")
	@Operation(summary = "Deletando Cliente", 
	description = "Deletando Cliente", 
	tags = {"Pessoas"},
	responses = {
			@ApiResponse(description= "Sem Content", responseCode = "204", content = @Content), 
			@ApiResponse(description= "Falhou", responseCode = "400", content = @Content), 
			@ApiResponse(description= "Não autorizado", responseCode = "401", content = @Content), 
			@ApiResponse(description= "Página nao encontrada", responseCode = "404", content = @Content), 
			@ApiResponse(description= "Servidor não encontrado", responseCode = "500", content = @Content) 

})
	public ResponseEntity<?> Excluir(@PathVariable(value = "id") Long id) throws Exception {
		
		pessoaService.excluir(id);	
		return ResponseEntity.noContent().build();
	}
	

}

