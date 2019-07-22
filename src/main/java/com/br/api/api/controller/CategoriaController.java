package com.br.api.api.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.api.event.RecursoCriadoEvent;
import com.br.api.api.modelo.Categoria;
import com.br.api.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();

	}

	@PostMapping
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

	// metodo que faz busca por id
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarporCodigo(@PathVariable("codigo") Long codigo) {
		 Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		//return categoriaRepository.findById(codigo).map(ResponseEntity::ok)
			//	.orElseGet(() -> ResponseEntity.notFound().build());
		return  categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void remover(@PathVariable Long codigo) {
		categoriaRepository.deleteById(codigo); 
	}
}


// metodo que faz busca por id
/*
 * public Categoria buscarporcodigo(Long codigo) throws ObjectNotFoundException
 * { Optional<Categoria> categoriaSalva = categoriaRepository.findById(codigo);
 * return categoriaSalva .orElseThrow(() -> new ObjectNotFoundException(
 * "objeto não encontrado id:" + codigo + ", tipo " +
 * Categoria.class.getName())); } }
 */

/*
 * // metodo que faz busca por id
 * 
 * @GetMapping("/{codigo}") public ResponseEntity<Categoria>
 * buscarporCodigo(@PathVariable(value = "codigo") Long categoriaId) throws
 * ResourceNotFoundException { Categoria categoria =
 * categoriaRepository.findById(categoriaId) .orElseThrow(() -> new
 * ResourceNotFoundException("Categoria não encontrado o codigo :: " +
 * categoriaId)); // return ResponseEntity.ok().body(categoria); return
 * categoria != null ? ResponseEntity.ok(categoria) :
 * ResponseEntity.notFound().build();
 * 
 * }
 * 
 * }
 */
