package com.utfpr.web2.orientacao.orientacaoweb2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="orientacao")
public class Orientacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrientacao;
	
	@NotEmpty
	private String descricaoOrientacao;
	
	@NotEmpty
	private String orientadoOrientacao;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_professor_orientacao")
	private Professor professor;

	public int getIdOrientacao() {
		return idOrientacao;
	}

	public void setIdOrientacao(int idOrientacao) {
		this.idOrientacao = idOrientacao;
	}

	public String getDescricaoOrientacao() {
		return descricaoOrientacao;
	}

	public void setDescricaoOrientacao(String descricaoOrientacao) {
		this.descricaoOrientacao = descricaoOrientacao;
	}

	public String getOrientadoOrientacao() {
		return orientadoOrientacao;
	}

	public void setOrientadoOrientacao(String orientadoOrientacao) {
		this.orientadoOrientacao = orientadoOrientacao;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOrientacao;
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
		Orientacao other = (Orientacao) obj;
		if (idOrientacao != other.idOrientacao)
			return false;
		return true;
	}

}
