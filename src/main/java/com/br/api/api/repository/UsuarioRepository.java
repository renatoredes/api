package com.br.api.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.api.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);
}
