package com.bebeto.controlaDin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.UsuarioRepository;

@Service
public class UsuarioLogadoService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioLogado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(usuario==null){
            throw new IllegalArgumentException("Usuário não encontrado para o email: " + email);
        }
        return usuario;
    }
}
