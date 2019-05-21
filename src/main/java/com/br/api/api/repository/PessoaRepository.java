package com.br.api.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.api.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
