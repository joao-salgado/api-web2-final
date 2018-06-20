package com.utfpr.web2.orientacao.orientacaoweb2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.utfpr.web2.orientacao.orientacaoweb2.model.Orientacao;

public interface OrientacaoRepository extends JpaRepository<Orientacao, Long> {
	
	public Page<Orientacao> findByDescricaoOrientacao(String descricao, Pageable pageable);

}
