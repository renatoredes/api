package com.gs.school.api.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gs.school.api.model.Funcionario;
import com.gs.school.api.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping("/listar")
	public ResponseEntity<Object> listar() {

		ResponseEntity<Object> retorno = null;

		try {
			List<Funcionario> lista = funcionarioService.listarTodos();

			retorno = ResponseEntity.ok(lista);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return retorno;
	}
	
	@PutMapping(path = "/atualizar")
	public ResponseEntity<Object> atualizar(@RequestBody Funcionario funcionario) {

		Map<String, Object> response = new HashMap<>();
		ResponseEntity<Object> retorno = null;

		try {

			if (funcionario == null || funcionario.getCodigo() == null) {
				response.put("mensagem", "Funcionário ou Código da Funcionário não pode ser nulo!");
				retorno = new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
				return retorno;
			}

			funcionario = funcionarioService.salvar(funcionario);

			retorno = new ResponseEntity<Object>(funcionario, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();

			retorno = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return retorno;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable("id") Long codigo) {

		Map<String, Object> response = new HashMap<>();
		ResponseEntity<Object> retorno = null;

		try {

			if (codigo == null) {
				response.put("mensagem", "Id do funcionário não pode ser nulo!");
				retorno = new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
				return retorno;
			}

			Funcionario funcionario = funcionarioService.buscarFuncionarioPeloCodigo(codigo);

			retorno = ResponseEntity.ok(funcionario);

		} catch (Exception e) {
			e.printStackTrace();

			retorno = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return retorno;
	}
	
	//gs-school begin dlcschneider
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Funcionario cadastrar(@RequestBody Funcionario funcionario){
		return funcionarioService.salvar(funcionario);
	}
	//gs-school end dlcschneider
	
	//gs-school begin dlcschneider
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable("codigo") Long codigo) {
		funcionarioService.removerFuncionario(codigo);
	}
	//gs-school end dlcschneider
	
	
	
	
}
