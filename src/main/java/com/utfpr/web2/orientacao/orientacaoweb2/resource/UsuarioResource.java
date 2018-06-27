package com.utfpr.web2.orientacao.orientacaoweb2.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utfpr.web2.orientacao.orientacaoweb2.model.Usuario;
import com.utfpr.web2.orientacao.orientacaoweb2.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public ResponseEntity<Usuario> toCreate(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		usuario.setSenhaUsuario((passwordEncoder().encode(usuario.getSenhaUsuario())));
		Usuario us = usuarioRepository.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(us);
	}
	
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
