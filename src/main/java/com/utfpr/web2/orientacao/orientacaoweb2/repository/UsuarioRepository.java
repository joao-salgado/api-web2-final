package com.utfpr.web2.orientacao.orientacaoweb2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utfpr.web2.orientacao.orientacaoweb2.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
