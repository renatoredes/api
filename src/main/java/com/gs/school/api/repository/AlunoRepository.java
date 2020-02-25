package com.gs.school.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gs.school.api.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	
	@Query(value = " select p from Aluno p where p.numeroCertidaoNascimento =:certidao")
	public Optional<Aluno> findAlunoByCpf(@Param("certidao") String certidao);
}
