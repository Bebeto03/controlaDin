package com.bebeto.controlaDin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.bebeto.controlaDin.dto.UsuarioDto;
import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.UsuarioRepository;

@Service
public class RegisterService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerUser(UsuarioDto usuarioDto, BindingResult result){
        if(!usuarioDto.getPassword().equals(usuarioDto.getConfirmPassword())){
            result.addError(new FieldError("usuarioDto", "confirmPassword", "As senhas não são iguais."));
        }
        Usuario usuario = usuarioRepository.findByEmail(usuarioDto.getEmail());
        if(usuario!=null){
            result.addError(new FieldError("usuarioDto", "email", "Esse email já está sendo utilizado."));
        }
        if(result.hasErrors()){
            return false;
        }
        Usuario novoUsuario = new Usuario();
        novoUsuario.setName(usuarioDto.getName());
        novoUsuario.setEmail(usuarioDto.getEmail());
        novoUsuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
        novoUsuario.setRole("client");
        usuarioRepository.save(novoUsuario);
        return true;
    }
}
