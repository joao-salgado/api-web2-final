package com.utfpr.web2.orientacao.orientacaoweb2.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utfpr.web2.orientacao.orientacaoweb2.model.Professor;
import com.utfpr.web2.orientacao.orientacaoweb2.repository.ProfessorRepository;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping
	public List<Professor> search() {
		return professorRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Professor> toCreate(@Valid @RequestBody Professor professor, HttpServletResponse response) {
		Professor prof = professorRepository.save(professor);
		return ResponseEntity.status(HttpStatus.CREATED).body(prof);
	}
	
}
