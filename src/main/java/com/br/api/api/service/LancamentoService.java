package com.br.api.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.api.api.exception.PessoaInexistenteOuInativaException;
import com.br.api.api.modelo.Lancamento;
import com.br.api.api.modelo.Pessoa;
import com.br.api.api.repository.LancamentoRepository;
import com.br.api.api.repository.PessoaRepository;

@Service
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento salvar(Lancamento lancamento) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		
		  if (pessoa == null || pessoa.get().isInativo()) { throw new
		  PessoaInexistenteOuInativaException(); }
		 

		/*
		 * if (pessoa.isPresent()) { throw new PessoaInexistenteOuInativaException(); }
		 */

		return lancamentoRepository.save(lancamento);
	}

}