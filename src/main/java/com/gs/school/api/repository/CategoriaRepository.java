package com.gs.school.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gs.school.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
