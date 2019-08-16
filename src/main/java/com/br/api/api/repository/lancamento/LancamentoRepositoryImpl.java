package com.br.api.api.repository.lancamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.br.api.api.modelo.Categoria;
import com.br.api.api.modelo.Categoria_;
import com.br.api.api.modelo.Lancamento;
import com.br.api.api.modelo.Lancamento_;
import com.br.api.api.modelo.Pessoa_;
import com.br.api.api.modelo.projection.ResumoLancamento;
import com.br.api.api.repository.filter.LancamentoFilter;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {

		CriteriaBuilder builder = manager.getCriteriaBuilder(); // Constroi a criteria
		CriteriaQuery<Lancamento> criteriaQuery = builder.createQuery(Lancamento.class);
		Root<Lancamento> root = criteriaQuery.from(Lancamento.class);

		// criar as restrições
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteriaQuery.where(predicates);

		TypedQuery<Lancamento> query = manager.createQuery(criteriaQuery);
		adcionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
	}

	@Override
	public Page<ResumoLancamento> resumoLancamento(LancamentoFilter lancamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		/*Retorna uma critia de resumo lançamento*/
		CriteriaQuery<ResumoLancamento> criteriaQuery = builder.createQuery(ResumoLancamento.class);
		/*Faz uma consulta de dados da entidade de Lançamento porque resumoLancamento não é uma entidade*/
		Root<Lancamento> root = criteriaQuery.from(Lancamento.class);
		/* Faz o select nos campos que estão no construtor de ResumoLancamento*/
		criteriaQuery.select(builder.construct(ResumoLancamento.class,
				root.get(Lancamento_.codigo), 
				root.get(Lancamento_.descricao), 
				root.get(Lancamento_.dataVencimento), 
				root.get(Lancamento_.dataPagamento),
				root.get(Lancamento_.valor),
				root.get(Lancamento_.tipo),
				root.get(Lancamento_.categoria).get(Categoria_.nome),
				root.get(Lancamento_.pessoa).get(Pessoa_.nome)));
		
		// criar as restrições
				Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
				/*Filtra*/
				criteriaQuery.where(predicates);
				/*Cria a consulta */
				TypedQuery<ResumoLancamento> query = manager.createQuery(criteriaQuery);
				/*adciona as restrições de paginação*/
				adcionarRestricoesDePaginacao(query, pageable);

				return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));

	
	}

	private Predicate[] criarRestricoes(LancamentoFilter lancamentoFilter, CriteriaBuilder builder,
			Root<Lancamento> root) {

		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(lancamentoFilter.getDescricao())) {
			/*
			 * Estou usando meta model para evitar erro de digitaçãp na string, e evitar
			 * escrever escrint exemplo: decricao
			 * predicates.add(builder.like(builder.lower(root.get("descricao")), "%"
			 * +lancamentoFilter.getDescricao().toLowerCase() +"%"));
			 */
			predicates.add(builder.like(builder.lower(root.get(Lancamento_.descricao)),
					"%" + lancamentoFilter.getDescricao().toLowerCase() + "%"));
		}
		if (lancamentoFilter.getDataVencimentoDe() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(Lancamento_.dataVencimento),
					lancamentoFilter.getDataVencimentoDe()));
		}
		if (lancamentoFilter.getDataVencimentoAte() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(Lancamento_.dataVencimento),
					lancamentoFilter.getDataVencimentoAte()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adcionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(LancamentoFilter lancamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<Lancamento> root = criteriaQuery.from(Lancamento.class);

		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteriaQuery.where(predicates);

		criteriaQuery.select(builder.count(root));

		return manager.createQuery(criteriaQuery).getSingleResult();
	}

}
