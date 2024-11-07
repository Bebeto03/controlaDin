package com.bebeto.controlaDin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping("/register")
    public String showRegisterForm(){
        return "register";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }


}
