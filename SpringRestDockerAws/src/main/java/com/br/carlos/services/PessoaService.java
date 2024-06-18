package com.br.carlos.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.br.carlos.model.Pessoa;

@Service
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PessoaService.class.getName());
	
	public Pessoa findById(String id ) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setNome("carlos");
		pessoa.setSobrenome("rosa");
		pessoa.setEndereco("ubatuba");
		pessoa.setSexo("M");
		
		logger.info("Pessoa aqui");
		return  pessoa;
		
	}
	public List<Pessoa> findall() {
		
		List<Pessoa> pessoaall = new ArrayList<Pessoa>();
		
		for (int i = 0; i < 8; i++) {
			
			Pessoa pessoa = mockPessoa(i);
			pessoaall.add(pessoa);
		}
		
		logger.info("Pessoa aqui All");
		return  pessoaall;
		
	}
	private Pessoa mockPessoa(int i) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setNome("carlos " + i);
		pessoa.setSobrenome("rosa " + i);
		pessoa.setEndereco("ubatuba " + i);
		pessoa.setSexo("M");

		return pessoa;
	}

}
