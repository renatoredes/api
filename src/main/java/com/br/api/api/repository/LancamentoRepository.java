package com.br.api.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.api.modelo.Lancamento;

public interface LancamentoRepository  extends JpaRepository<Lancamento, Long>{

}
