package com.gs.school.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;


	private String nome;

	private String receitas;
	
	private String despesas;
	
	private String contas;
	
	private String servicos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getReceitas() {
		return receitas;
	}

	public void setReceitas(String receitas) {
		this.receitas = receitas;
	}

	public String getDespesas() {
		return despesas;
	}

	public void setDespesas(String despesas) {
		this.despesas = despesas;
	}

	public String getContas() {
		return contas;
	}

	public void setContas(String contas) {
		this.contas = contas;
	}

	public String getServicos() {
		return servicos;
	}

	public void setServicos(String servicos) {
		this.servicos = servicos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((contas == null) ? 0 : contas.hashCode());
		result = prime * result + ((despesas == null) ? 0 : despesas.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((receitas == null) ? 0 : receitas.hashCode());
		result = prime * result + ((servicos == null) ? 0 : servicos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (contas == null) {
			if (other.contas != null)
				return false;
		} else if (!contas.equals(other.contas))
			return false;
		if (despesas == null) {
			if (other.despesas != null)
				return false;
		} else if (!despesas.equals(other.despesas))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (receitas == null) {
			if (other.receitas != null)
				return false;
		} else if (!receitas.equals(other.receitas))
			return false;
		if (servicos == null) {
			if (other.servicos != null)
				return false;
		} else if (!servicos.equals(other.servicos))
			return false;
		return true;
	}
	
	
	

}
