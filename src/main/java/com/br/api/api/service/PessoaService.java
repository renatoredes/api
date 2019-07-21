package com.br.api.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.api.api.modelo.Pessoa;
import com.br.api.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {

		Optional<Pessoa> pessoaOptional = pessoaRepository.findById(codigo);

		if (!pessoaOptional.isPresent())
			throw new EmptyResultDataAccessException(1);

		pessoa.setCodigo(codigo);
		pessoaRepository.save(pessoa);
		return pessoaRepository.save(pessoa);
	}

}
