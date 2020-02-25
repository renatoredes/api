package com.gs.school.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name="id_Pessoa")
@DiscriminatorValue(value="Funcionario")
public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "funcao_funcionario")
	private String funcaoFuncionario;

	@NotNull
	@Column(name = "nivel_escolar")
	private String nivelEscolar;

	@Column(name = "tipo_ensino_medio_cursando")
	private String tipoEnsinoMedioCursando;

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="cracha")
	private String cracha;
	
	public String getCracha() {
		return cracha;
	}
	
	public void setCracha(String cracha) {
		this.cracha = cracha;
	}

	public String getFuncaoFuncionario() {
		return funcaoFuncionario;
	}

	public void setFuncaoFuncionario(String funcaoFuncionario) {
		this.funcaoFuncionario = funcaoFuncionario;
	}

	public String getNivelEscolar() {
		return nivelEscolar;
	}

	public void setNivelEscolar(String nivelEscolar) {
		this.nivelEscolar = nivelEscolar;
	}

	public String getTipoEnsinoMedioCursando() {
		return tipoEnsinoMedioCursando;
	}

	public void setTipoEnsinoMedioCursando(String tipoEnsinoMedioCursando) {
		this.tipoEnsinoMedioCursando = tipoEnsinoMedioCursando;
	}


}
