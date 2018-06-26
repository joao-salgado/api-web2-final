package com.utfpr.web2.orientacao.orientacaoweb2.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.utfpr.web2.orientacao.orientacaoweb2.model.Usuario;
import com.utfpr.web2.orientacao.orientacaoweb2.repository.UsuarioRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository userAccountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> user = userAccountRepository.findByEmailUsuario(email);
		Usuario userAccount = user.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
		return new User(userAccount.getEmailUsuario(), userAccount.getSenhaUsuario(), getPermissions(userAccount));
	}
	
	private Collection<? extends GrantedAuthority> getPermissions(Usuario userAccount) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		return authorities;
	}
	
}
