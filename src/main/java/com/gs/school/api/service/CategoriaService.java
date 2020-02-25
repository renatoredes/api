package com.gs.school.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gs.school.api.model.Categoria;
import com.gs.school.api.model.Pessoa;
import com.gs.school.api.repository.CategoriaRepository;
import com.gs.school.api.repository.PessoaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository Repository;

	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalva = buscarCategoriaPeloCodigo(codigo);
		
		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
		return Repository.save(categoriaSalva);
	}

	
	
	public Categoria buscarCategoriaPeloCodigo(Long codigo) {
		Categoria categoriaSalva = Repository.findOne(codigo);
		if (categoriaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoriaSalva;
	}
	
}
