package com.gs.school.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sobre_nome")
	private String sobrenome;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "rg")
	private String rg;
	
	@Column(name = "numero_certidao_nascimento")
	private String numeroCertidaoNascimento;
	
	@Column(name = "justificativa_documento")
	private String justificativaDocumento;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
    
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "cor_raca")
	private String corRaca;
	
	@Column(name = "nome_filiacao_resonsavel_1")
	private String  nomeFiliacaoResponsavel_1;
	
	@Column(name = "nome_filiacao_resonsavel_2")
	private String  nomeFiliacaoResponsavel_2;
	
	@Column(name = "sobre_nome_filiacao_resonsavel_1")
	private String sobreNomeFiliacaoResponsavel_1;
	
	@Column(name = "sobre_nome_filiacao_resonsavel_2")
	private String sobreNomeFiliacaoResponsavel_2;
	
	@Column(name = "deficiencia")
	private String deficiencia;
	
	@Column(name = "tipo_deficiencia")
	private String tipoDeficiencia;
	
	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "celular")
	private String celular;
	
	@Column(name = "nis")
	private String nis;

	@Embedded
	private Endereco endereco;

	@Column(name = "ativo")
	private Boolean ativo;
	
	
	
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


	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNumeroCertidaoNascimento() {
		return numeroCertidaoNascimento;
	}

	public void setNumeroCertidaoNascimento(String numeroCertidaoNascimento) {
		this.numeroCertidaoNascimento = numeroCertidaoNascimento;
	}

	public String getJustificativaDocumento() {
		return justificativaDocumento;
	}

	public void setJustificativaDocumento(String justificativaDocumento) {
		this.justificativaDocumento = justificativaDocumento;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCorRaca() {
		return corRaca;
	}

	public void setCorRaca(String corRaca) {
		this.corRaca = corRaca;
	}

	public String getNomeFiliacaoResponsavel_1() {
		return nomeFiliacaoResponsavel_1;
	}

	public void setNomeFiliacaoResponsavel_1(String nomeFiliacaoResponsavel_1) {
		this.nomeFiliacaoResponsavel_1 = nomeFiliacaoResponsavel_1;
	}

	public String getNomeFiliacaoResponsavel_2() {
		return nomeFiliacaoResponsavel_2;
	}

	public void setNomeFiliacaoResponsavel_2(String nomeFiliacaoResponsavel_2) {
		this.nomeFiliacaoResponsavel_2 = nomeFiliacaoResponsavel_2;
	}

	public String getSobreNomeFiliacaoResponsavel_1() {
		return sobreNomeFiliacaoResponsavel_1;
	}

	public void setSobreNomeFiliacaoResponsavel_1(String sobreNomeFiliacaoResponsavel_1) {
		this.sobreNomeFiliacaoResponsavel_1 = sobreNomeFiliacaoResponsavel_1;
	}

	public String getSobreNomeFiliacaoResponsavel_2() {
		return sobreNomeFiliacaoResponsavel_2;
	}

	public void setSobreNomeFiliacaoResponsavel_2(String sobreNomeFiliacaoResponsavel_2) {
		this.sobreNomeFiliacaoResponsavel_2 = sobreNomeFiliacaoResponsavel_2;
	}

	public String getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public String getTipoDeficiencia() {
		return tipoDeficiencia;
	}

	public void setTipoDeficiencia(String tipoDeficiencia) {
		this.tipoDeficiencia = tipoDeficiencia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	@JsonIgnore
	@Transient
	public boolean isInativo() {
		return !this.ativo;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
