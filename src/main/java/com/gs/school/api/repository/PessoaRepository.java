package com.gs.school.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gs.school.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
