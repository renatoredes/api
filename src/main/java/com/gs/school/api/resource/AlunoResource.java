package com.gs.school.api.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs.school.api.model.Aluno;
import com.gs.school.api.repository.AlunoRepository;

@RestController
@RequestMapping({ "/aluno" })
public class AlunoResource {

	@Autowired
	private AlunoRepository alunoRepository;

	@GetMapping
	public ResponseEntity<List<Aluno>> listarAlunos() {
		return ResponseEntity.ok(alunoRepository.findAll());
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Aluno> buscarAlunoPorCodigo(@PathVariable Long id) {
		Aluno aluno = alunoRepository.findOne(id);
		return aluno != null ? ResponseEntity.ok(aluno) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping
	public ResponseEntity<Aluno> salvarAluno(@Valid @RequestBody Aluno aluno) {

		if (aluno.getNumeroCertidaoNascimento() != null) {
			String certidao = aluno.getNumeroCertidaoNascimento().replaceAll(".", "");
			certidao = certidao.replaceAll("-", "");
			Optional<Aluno> alunoDB = alunoRepository.findAlunoByCpf(certidao);

			if (alunoDB.isPresent()) {
				BeanUtils.copyProperties(aluno, alunoDB, "codigo");
				return ResponseEntity.ok(alunoRepository.save(alunoDB.get()));
			}
		}

		return ResponseEntity.ok(alunoRepository.save(aluno));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Aluno> alterar(@PathVariable("id") Long id, @Valid @RequestBody Aluno aluno) {

		Aluno alunoObject = alunoRepository.findOne(id);
		if (alunoObject != null) {
			BeanUtils.copyProperties(aluno, alunoObject, "codigo");
			return ResponseEntity.ok(alunoRepository.save(alunoObject));
		} else {
			return ResponseEntity.ok(alunoRepository.save(aluno));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> deletar(@PathVariable Long id) {

		Aluno alunoObject = alunoRepository.findOne(id);
		if (alunoObject != null) {
			alunoRepository.delete(alunoObject);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
