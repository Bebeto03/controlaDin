package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bebeto.controlaDin.dto.UsuarioDto;
import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("usuarioDto", new UsuarioDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @Valid @ModelAttribute UsuarioDto usuarioDto, BindingResult result){

        if(!usuarioDto.getPassword().equals(usuarioDto.getConfirmPassword())){
            result.addError(new FieldError("usuarioDto", "confirmPassword", "As senhas não são iguais."));
        }

        Usuario usuario = usuarioRepository.findByEmail(usuarioDto.getEmail());

        if(usuario != null){
            result.addError(new FieldError("usuarioDto", "email", "Esse email já está sendo utilizado."));
        }

        if(result.hasErrors()){
            return "register";
        }

        Usuario newUsuario = new Usuario();
        newUsuario.setName(usuarioDto.getName());
        newUsuario.setEmail(usuarioDto.getEmail());
        newUsuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
        newUsuario.setRole("client");
        usuarioRepository.save(newUsuario);

        return "redirect:/login";

    }

}
