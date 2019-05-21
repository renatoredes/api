package com.br.api.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.api.api.exception.ResourceNotFoundException;
import com.br.api.api.modelo.Categoria;
import com.br.api.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();

	}

	@PostMapping
	public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(categoriaSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(categoriaSalva);
	}

	/*
	 * @GetMapping("/{codigo}") public ResponseEntity<Categoria>
	 * buscarporCodigo(@PathVariable(value = "codigo") Long categoriaId) throws
	 * ResourceNotFoundException { Categoria categoria =
	 * categoriaRepository.findById(categoriaId).orElseThrow( () -> new
	 * ResourceNotFoundException("Categoria não encontrado o codigo :: " +
	 * categoriaId)); return ResponseEntity.ok().body(categoria); return categoria
	 * != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	 * 
	 * }
	 */

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("codigo") Long codigo){
	    return categoriaRepository.findById(codigo)
	      .map(ResponseEntity::ok)
	      .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
}