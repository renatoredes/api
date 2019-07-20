package com.br.api.api.controller;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import com.br.api.api.modelo.Lancamento;
import com.br.api.api.repository.LancamentoRepository;

@RestController
@RequestMapping("lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	private List<Lancamento> listar() {
		return lancamentoRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Lancamento> criar(@RequestBody Lancamento lancamento, HttpServletResponse response) {
		Lancamento lancamentoSalva = lancamentoRepository.save(lancamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalva);
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarporCodigo(@PathVariable("codigo") Long codigo) {
		return lancamentoRepository.findById(codigo).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void remover(@PathVariable Long codigo) {
		lancamentoRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Object> updateStudent(@RequestBody Lancamento lancamento, @PathVariable long codigo) {

		Optional<Lancamento> lancamentoOptional = lancamentoRepository.findById(codigo);

		if (!lancamentoOptional.isPresent())
			return ResponseEntity.notFound().build();

		lancamento.setCodigo(codigo);

		lancamentoRepository.save(lancamento);

		// return ResponseEntity.ok().build();
		return ResponseEntity.ok().body(lancamento);
	}
}