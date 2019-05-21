package com.br.api.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.api.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	
}
