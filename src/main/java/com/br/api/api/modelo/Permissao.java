package com.br.api.api.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "permissao")
@Getter
@Setter
@EqualsAndHashCode
public class Permissao {

	@Id
	private Long codigo;
	private String descricao;
}
