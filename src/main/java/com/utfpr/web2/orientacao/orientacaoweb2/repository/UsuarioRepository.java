package com.utfpr.web2.orientacao.orientacaoweb2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utfpr.web2.orientacao.orientacaoweb2.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmailUsuario(String email);

}
