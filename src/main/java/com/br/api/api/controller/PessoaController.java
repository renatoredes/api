package com.br.api.api.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.api.event.RecursoCriadoEvent;
import com.br.api.api.modelo.Pessoa;
import com.br.api.api.repository.PessoaRepository;
import com.br.api.api.service.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	// dispara um Evento do Spring
	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	private List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarporCodigo(@PathVariable("codigo") Long codigo) {
		return pessoaRepository.findById(codigo).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void remover(@PathVariable Long codigo) {
		pessoaRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@Valid @RequestBody Pessoa pessoa, @PathVariable long codigo) {
		Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);
		return ResponseEntity.ok(pessoaSalva);
	}
					///Falta implementar a pessoa ativa
	/*
	 * @PutMapping("/{codigo}/ativo")
	 * 
	 * @ResponseStatus(HttpStatus.NO_CONTENT) public void
	 * atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean
	 * ativo) { pessoaService.atualizar(codigo, ativo); }
	 */
}
