package com.utfpr.web2.orientacao.orientacaoweb2.resource;

import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utfpr.web2.orientacao.orientacaoweb2.model.Orientacao;
import com.utfpr.web2.orientacao.orientacaoweb2.repository.OrientacaoRepository;

@RestController
@RequestMapping("/orientacao")
public class OrientacaoResource {
	
	@Autowired
	private OrientacaoRepository orientacaoRepository;
	
	@GetMapping
	public Page<Orientacao> search(String nomeProfessor, Pageable pageable) {
		
		if(nomeProfessor == null || nomeProfessor.isEmpty()) {
			return orientacaoRepository.findAll(pageable);
		} 
		
		return orientacaoRepository.findByProfessorNomeProfessorContainingIgnoreCase(nomeProfessor, pageable);
	}
	
	@PostMapping
	public ResponseEntity<Orientacao> toCreate(@Valid @RequestBody Orientacao orientacao, HttpServletResponse response) {
		Orientacao ori = orientacaoRepository.save(orientacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(ori);
	}

}
