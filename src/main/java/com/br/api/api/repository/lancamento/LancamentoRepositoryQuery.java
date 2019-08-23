package com.br.api.api.repository.lancamento;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.br.api.api.modelo.Lancamento;
import com.br.api.api.modelo.projection.ResumoLancamento;
import com.br.api.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	/*Filtro com paginação*/
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);

	/*Filtro com paginação e dados resumidos de lançamentos */
	public Page<ResumoLancamento> resumoLancamento (LancamentoFilter lancamentoFilter, Pageable pageable);
	

}
