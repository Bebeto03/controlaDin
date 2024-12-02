package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bebeto.controlaDin.dto.UsuarioDto;
import com.bebeto.controlaDin.service.RegisterService;

import jakarta.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;
    
    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("usuarioDto", new UsuarioDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @Valid @ModelAttribute UsuarioDto usuarioDto, BindingResult result){
        if(!registerService.registerUser(usuarioDto, result)){
            return "register";
        }
        return "redirect:/login";
    }

}
