package com.bebeto.controlaDin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebeto.controlaDin.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public Usuario findByEmail(String email);
    
}
