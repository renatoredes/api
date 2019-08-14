package com.br.api.api.modelo.projection;
/*
 * Classe responsavel por listar um resumo de lançamento 
 * Foi colocador String em pessoa e em Categoria porque a ideia é traser apenas o nome da pessoa e a categoria
 */

import java.math.BigDecimal;
import java.time.LocalDate;

import com.br.api.api.modelo.TipoLancamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResumoLancamento {

	private Long codigo;
	private String descricao;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private BigDecimal valor;
	private TipoLancamento tipo;
	private String categoria;
	private String pessoa;

}
