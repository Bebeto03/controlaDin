package com.bebeto.controlaDin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/controlaDin/profile")
    public String showProfilePage(){
        return "profile";
    }
}
