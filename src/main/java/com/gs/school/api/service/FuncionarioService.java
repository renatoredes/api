package com.gs.school.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gs.school.api.model.Funcionario;
import com.gs.school.api.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<Funcionario> listarTodos() {
		return funcionarioRepository.findAll();
	}

	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario buscarFuncionarioPeloCodigo(Long codigo) {
		Funcionario funcionarioSalva = funcionarioRepository.findOne(codigo);
		if (funcionarioSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return funcionarioSalva;
	}
	
	public void removerFuncionario(Long codigo) {
		Funcionario funcionario = funcionarioRepository.getOne(codigo);
		if(funcionario!=null) {
			funcionarioRepository.delete(codigo);
		}
	}
}	
