package com.gs.school.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gs.school.api.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
