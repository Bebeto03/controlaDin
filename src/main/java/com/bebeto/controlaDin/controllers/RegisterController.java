package com.bebeto.controlaDin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bebeto.controlaDin.entities.User;
import com.bebeto.controlaDin.repositories.UserRepository;

import jakarta.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/register")
    public String showRegisterForm(Model model){

        model.addAttribute("user", new User());
        
        return "register";

    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model){

        if(userRepository.existsByEmail(user.getEmail())){
            bindingResult.rejectValue("email", "email.duplicado","Este email já foi cadastrado.");
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }

        userRepository.save(user);
        return "redirect:/login";

    }

}
